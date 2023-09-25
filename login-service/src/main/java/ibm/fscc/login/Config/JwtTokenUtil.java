package ibm.fscc.login.Config;

import ibm.fscc.login.Data.Login;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

import static ibm.fscc.login.Data.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static ibm.fscc.login.Data.Constants.SIGNING_KEY;


@Component
public class JwtTokenUtil  implements Serializable{
    
    public String getEmailFromToken(String token){
        return getClaimFromToken(token,Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }




     public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Login user) {
        return doGenerateToken(user.getUserEmail());
    }

      private String doGenerateToken(String subject) {

        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://ameinberg")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails uD){
        final String username = getEmailFromToken(token);
        return (
            username.equals(uD.getUsername())
                && !isTokenExpired(token));
        
    }

}
