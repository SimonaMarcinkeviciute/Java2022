package lt.codeacademy.libraryapi.config;

import lt.codeacademy.libraryapi.security.filter.JwtAuthenticationFilter;
import lt.codeacademy.libraryapi.security.filter.JwtAuthorizationFilter;
import lt.codeacademy.libraryapi.security.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
public class SecurityConfig {

    private final String h2Path;

    //
    public SecurityConfig(@Value("${spring.h2.console.path}") String h2Path) {
        this.h2Path = h2Path+ "/**";
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationConfiguration authenticationConfiguration, JwtService jwtService) throws Exception {

        //csrf - disable, kad vartotojas galetu prisijungti is lango kuri paduos pats serveris

        //mums nereikia sesiju, pakeiciam sisijos sukurimo logika, kiekviena uzklausa
        //neturi buti susieta su sesija, nes mes siusim jbt token
        //sessionCreationPolicy(SessionCreationPolicy.STATELESS) isjungiam sesija

        //visi request turi buti autentifikuoti
        //.authorizeRequests().anyRequest().authenticated()

        //.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        //jei ivyksta exeption by defoult grazintume , kad nemestu error i frontenda

        //resistruojam JwtAuthenticationFilter, pridedam filtra prie configuracijos

        //authenticationConfiguration.getAuthenticationManager() - sita sukurta ojekta paduodam
        //filtrui, i
        //idejom filtra,kad kiekvienas requestas butu prafiltruojamas,, sitas butent tam, kad vartotojas prisilogintu
        //tada jis kvieciamas
        //authentication manager - kad authentifikuoti vartuotoja

        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/books", "/users/registration", "/users/registration/{userName}")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager(), jwtService))
                .addFilter(new JwtAuthorizationFilter(authenticationConfiguration.getAuthenticationManager(), jwtService));

        return http.build();
    }

    //securiti ignorina sita path h2
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().antMatchers(h2Path);
    }
}

//antMatchers("/files/**").permitAll()po authenticatedRequst rasosi

