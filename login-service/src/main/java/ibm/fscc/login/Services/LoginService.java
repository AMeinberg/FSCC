package ibm.fscc.login.Services;

//import ibm.fscc.login.Data.Login;
import ibm.fscc.login.Shared.LoginDTO;

public interface LoginService {
    public LoginDTO getLogin(String email);

    public int delete(int user_id);

}
