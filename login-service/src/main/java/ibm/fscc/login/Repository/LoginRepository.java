package ibm.fscc.login.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.fscc.login.Data.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long>{
    Login findByUserId(int user_id);

    Login findByUserEmail(String user_email);

    int deleteByUserId(int user_id);

    //Login getUserEmailByToken(String token);
}
