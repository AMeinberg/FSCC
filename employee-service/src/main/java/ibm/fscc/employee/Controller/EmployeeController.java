
package ibm.fscc.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ibm.fscc.employee.Data.Employee;
import ibm.fscc.employee.Repository.EmployeeRepository;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository ERepo;

	
    @PostMapping("/add")
    public Employee saveEmployeeDetails(@RequestBody Employee log){
        Employee l = new Employee();

        l.setFirstName(log.getFirstName());
        l.setLastName(log.getLastName());
        l.setAddress(log.getAddress());
        l.setState(log.getState());
        l.setZip(log.getZip());
        l.setCellPhone(log.getCellPhone());
        l.setHomePhone(log.getHomePhone());
        l.setEmail(log.getEmail());

        ERepo.save(l);
     
        return l;
    }

    @GetMapping("/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		// This returns a JSON or XML with the users
		return ERepo.findAll();
	}

    @DeleteMapping("/hello/{user_id}")
    public Long deleteById(@PathVariable("user_id") Long id) {

       ERepo.deleteById(id);
       return id;
    }

}