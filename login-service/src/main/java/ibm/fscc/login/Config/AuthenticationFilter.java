package ibm.fscc.login.Config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.fscc.login.Data.Constants;
import ibm.fscc.login.Data.Login;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter  {

    private CustomAuthenticationProvider provider;


    public AuthenticationFilter(CustomAuthenticationProvider provider){
        this.provider = provider;
    }
    public AuthenticationFilter(){}


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
                try {
                    Login l = new ObjectMapper().readValue(request.getInputStream(), Login.class);
                    Authentication authentication = new UsernamePasswordAuthenticationToken(l.getUserEmail(), l.getUserPassword());
                    return provider.authenticate(authentication);
                } catch (StreamReadException e) {
                    throw new RuntimeException();
                } catch (DatabindException e) {
                    throw new RuntimeException();
                } catch (IOException e) {
                  throw new RuntimeException();
                }
            
    }

   
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        System.out.println("SUCCCSESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS!!!!!!!!!!!!!");
       String token =  JWT.create()
       .withSubject(authResult.getName())
       .withExpiresAt(new Date(System.currentTimeMillis()+ 1800000))
       .sign(Algorithm.HMAC256(Constants.SECRET_KEY));
        response.addHeader(Constants.AUTHORIZATION, Constants.BEARER + token);
        System.out.println(token);
    }
    

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
                  System.out.println("FAILLLLLLLLLLLLLLLLLLLLLLLLl!!!!!!!!!!!!!");
          response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          response.getWriter().write(failed.getMessage());
          response.getWriter().flush();
    }
}