package ibm.fscc.login.Data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class AuthToken {

    private String token;
    private String username;

    public AuthToken(){

    }

    public AuthToken(String token, String username){
        this.token = token;
        this.username = username;
    }
}
