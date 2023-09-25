package ibm.fscc.employee.Repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.fscc.employee.Data.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}
