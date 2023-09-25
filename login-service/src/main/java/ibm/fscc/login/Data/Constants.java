package ibm.fscc.login.Data;

public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "ameinberg";
    public static final String BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String SECRET_KEY = System.getenv().getOrDefault("JWT_SECRET_KEY", "localsecret1234567890123456789012345");
}
