package lt.codeacademy.libraryapi.security.filter;

import lt.codeacademy.libraryapi.security.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//atsakingas uz visas uzklausas kurios ateinai musu aplikacija, jei yra token
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private static final String BEARER = "Bearer ";

    private final JwtService jwtService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //pasiemam key
        String authorization = request.getHeader("Authorization");

        //nevalidus taukenas jei neprasideda Bearer su tarpu taip pat
        if(authorization == null || !authorization.startsWith(BEARER)) {
            //kad praskipinti sita filtra, jei user eina per login, metam i kitus filtrus
            //kitas fltras praleis, nes context uzsetintas
            chain.doFilter(request, response);
            return;
        }

        //jei token yra, pirma pasiemam ji, nueme ta Bearer zodeli
        String token = authorization.replace(BEARER, "");
        //pasiemam authentication objekta, is metodo kuti pasirasem, per konstruktoriu pasiduodam jwtservice
        Authentication authentication = jwtService.parseToken(token);
        //isetinam authentication jau vartotojas authorizuotas
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }
}
