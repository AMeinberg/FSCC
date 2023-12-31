package ibm.fscc.login.Config;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.stereotype.Component;

import ibm.fscc.login.Data.Login;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{


    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {

         final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        if (name.equals("admin") && password.equals("system")) {
            final Login principal = new Login(name, password);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password);
            return auth;
        } else {
            return null;
        }
 
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
