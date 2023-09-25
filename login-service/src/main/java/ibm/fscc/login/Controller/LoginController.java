package ibm.fscc.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ibm.fscc.login.Data.Login;
import ibm.fscc.login.Repository.LoginRepository;
//import ibm.fscc.login.Shared.LoginDTO;
import ibm.fscc.login.Services.LoginServiceImpl;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginRepository LRepo;

    @Autowired
    private LoginServiceImpl LogServImpl;

    @PostMapping("/add")
    public Login getLoginDetails(@RequestBody Login log){
        Login l = new Login();
        l.setUserEmail(log.getUserEmail());
        l.setUserPassword(log.getUserPassword());
        LRepo.save(l);
        return l;
    }

    @GetMapping(path="/all")
	public @ResponseBody Iterable<Login> getAllLogins() {
		// This returns a JSON or XML with the users
		return LRepo.findAll();
	}

    @DeleteMapping("/trash/{user_id}")
    public void deleteById(@PathVariable("user_id") int id) {

        LogServImpl.delete(id);

    }
}
