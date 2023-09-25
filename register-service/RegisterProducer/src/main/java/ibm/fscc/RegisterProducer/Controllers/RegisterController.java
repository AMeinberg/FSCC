package ibm.fscc.RegisterProducer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibm.fscc.RegisterProducer.RegisterProducer;
//import ibm.fscc.RegisterProducer.Entities.Register;
import ibm.fscc.RegisterProducer.Entities.RegisterEvent;
import ibm.fscc.RegisterProducer.Repositories.RegisterEventRepository;

@RestController
public class RegisterController {
    @Autowired
        RegisterEventRepository regRepo;
    
    @Autowired
        RegisterProducer prod;
     @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {

        List<RegisterEvent> users = regRepo.findAll();
        return new ResponseEntity<>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.ACCEPTED);
    }
    @GetMapping("/pending")
    public ResponseEntity<?> getByStatusPending(){
          List<RegisterEvent> users = regRepo.findByStatus("Pending");
        return new ResponseEntity<>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.ACCEPTED);
    }
     @GetMapping("/accepted")
    public ResponseEntity<?> getByStatusAccepted(){
          List<RegisterEvent> users = regRepo.findByStatus("Accepted");
        return new ResponseEntity<>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.ACCEPTED);
    }
    @GetMapping("/email")
    public ResponseEntity<?> getByEmail(@RequestBody RegisterEvent event){
          List<RegisterEvent> users = regRepo.findByEmail(event.getEmail());
        return new ResponseEntity<>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.ACCEPTED);
    }

     @PostMapping(value = "/publish")
   public void sendMessageToKafkaTopic(@RequestBody String event) {
       this.prod.sendMessage(event);
   }

   @PutMapping("/pending/update")
public ResponseEntity<?> updateStatusToAccepted() {
        List<RegisterEvent> users = regRepo.findByStatus("Pending");
    
        if (users.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    
    
        for (RegisterEvent user : users) {
        regRepo.delete(user);
        user.setStatus("Accepted");
        regRepo.save(user);
    }
    
    return new ResponseEntity<>(users, HttpStatus.OK);
}

   @DeleteMapping("/clear")
   public void clearData(){
        regRepo.deleteAll();
   }
}
