
package ibm.fscc.apigateway.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Component;


import java.util.Date;


@Component
public class JwtUtil {


    public static final String SECRET = System.getenv().getOrDefault("JWT_SECRET_KEY", "localsecret1234567890123456789012345");


    public void validateToken(final String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(SECRET.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();

        String subject = claims.getSubject();
        Date expirationDate = claims.getExpiration();


    }



  
}