package ibm.fscc.login.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibm.fscc.login.Repository.LoginRepository;
import ibm.fscc.login.Shared.LoginDTO;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository LRepo;
    
    @Override
    public LoginDTO getLogin(String email) {
     
        throw new UnsupportedOperationException("Unimplemented method 'getLogin'");
    }

    @Override
    @Transactional
    public int delete(int user_id) {
       return LRepo.deleteByUserId(user_id);
    }
    
    
}
