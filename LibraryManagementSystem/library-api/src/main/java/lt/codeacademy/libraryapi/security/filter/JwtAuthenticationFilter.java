package lt.codeacademy.libraryapi.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.security.Login;
import lt.codeacademy.libraryapi.security.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//filtras kuris atsakingas uz userio irpaswordo authentifikavima
//kvieciamas tik tada kai yra post o path i login, tik tada kai norim prisiloginti
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //sumapinti du stringus i objekta
    private final ObjectMapper objectMapper;
    private final JwtService jwtService;

    //tam kad authentifikuoti vartotoja AuthenticationManager authenticationManager
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
        super(authenticationManager);
        this.objectMapper = new ObjectMapper();
        this.jwtService = jwtService;
    }

    //pakus token ir bandys authentifikuoti user
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            //gauname login objekta - pasakom, kad tas requestas butu ckonvertuojamas i login klase, is requesto pasiemam
            Login login = objectMapper.readValue(request.getReader(), Login.class);
            //kuriame tokena
            Authentication token = new UsernamePasswordAuthenticationToken(login.username(), login.password());

            //gaunat authentificatio, jei useris prisijungia
            return getAuthenticationManager().authenticate(token);
        }catch(Exception e) {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    //sitas metodas bus iskvieciamas, kai vartotojas sekmingai prisilogins,
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        //uzsetinam kontext, kad nebekritu 401, ir cia sudedam visa informacija apie useri, kad esam uzsilogine
        SecurityContextHolder.getContext().setAuthentication(authResult);


        String token = jwtService.generateToken((User)authResult.getPrincipal());
        //idedam i responce parametra token, ir sita grazinsim kaip rezultata atgal
        response.addHeader("Authorization", token);

        //jwtService.parseToken(token);
        //nenutraukiam filtru grandines
        chain.doFilter(request, response);
    }
}

//filtras is requesto pasiims login ir password ir kazka padarys

//ui sius uzklausa su username ir pasword i api, api rasdes toki user sukurs token, ir grazins, ir kitas requstas jau tures ta token
//jei bus nevalidus, npraleis

//prilogina, ideda i kontksta, sukuria token, ir idedam ihederi rezultata

