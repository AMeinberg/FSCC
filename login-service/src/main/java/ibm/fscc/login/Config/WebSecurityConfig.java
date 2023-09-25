package ibm.fscc.login.Config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomAuthenticationProvider prov;



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(prov);
        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                   .requestMatchers("/trash/{user_id}").permitAll()
                     .requestMatchers("/add").permitAll()
                        .requestMatchers("/all").permitAll()

                )
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }





}