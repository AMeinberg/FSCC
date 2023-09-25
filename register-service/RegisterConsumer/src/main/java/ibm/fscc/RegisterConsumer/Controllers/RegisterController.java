package ibm.fscc.RegisterConsumer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import ibm.fscc.RegisterConsumer.Entities.Register;
import ibm.fscc.RegisterConsumer.Entities.RegisterEvent;
import ibm.fscc.RegisterConsumer.Repositories.RegisterEventRepository;

public class RegisterController {
    @Autowired
        RegisterEventRepository regRepo;
     @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {

        List<RegisterEvent> users = regRepo.findAll();
        return new ResponseEntity<>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.ACCEPTED);
    }
}
