package lt.codeacademy.libraryapi.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import lt.codeacademy.libraryapi.dto.Role;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.naming.AuthenticationException;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final long tokenValidTimeMs;
    private final byte[] secretKey;

    //pasiemam key ir laika is properties
    //properciai nuskaitomi - @value, per konstruktoriu, toj anotacijoj nurodom ka nuskaityti tame properciu faile
    public JwtService(@Value("${security.jwt.secret.key}") byte[] secretKey,
                      @Value("#{${security.jwt.valid.token.min} * 60000}") long tokenValidTimeMs) {
        this.secretKey = secretKey;
        this.tokenValidTimeMs = tokenValidTimeMs;
    }

    //token reikalingas - kad autorizuoti vartotoja ir nereiketu jo ant kiekvieno request autorizuoti
    public String generateToken(User user) {
        Date date = new Date();
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setAudience("library-ui")
                .setIssuer("library-api")
                .setSubject(user.getUsername())
                .setExpiration(new Date(date.getTime() + tokenValidTimeMs))
                .setIssuedAt(date)
                .claim("roles", user.getRoles().stream().map(Role::getAuthority).toList())
                .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS512)
                .compact();
    }

    //issiparsinam token, sukuriam authentification objekta ir isidedam i security conkext holderi
    //tam, kad kai eisim giliau, patikrinti ar vartotojas gali prieiti prie tam tikru duomenu
    public Authentication parseToken(String token) {
        try {
            //susikuriam parseri is kurio galim pasiimti subject, claimus, expiration data
            //patikrinti ar tas token nepasiexpirino
            //susikuriam parse objekta su secret key
            JwtParser jwtParser = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build();

            //parsinam token, gaunam claim is kuriu galim pasiimti body
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            //is body galima pasiimti visa info ecpiration, audience i t.t
            Claims body = claimsJws.getBody();

            String userName = body.getSubject();
            List<SimpleGrantedAuthority> roles = ((List<String>) body.get("roles")).stream().map(SimpleGrantedAuthority::new).toList();

            return new UsernamePasswordAuthenticationToken(userName, null, roles);
        } catch(Exception e) {
            throw new InvalidTokenException();
        }
    }





    //secret key - sukuriant token pasirasinesim papildomu key, pasiziurim ar token nera pamodifikuotas
    //tam jis reikalingas
    //documentation -> https://github.com/jwtk/jjwt#jws-key-create-secret
    private String generateJwtSecretKey() {
        try {
            SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
            return Encoders.BASE64.encode(key.getEncoded());
        }catch(Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
