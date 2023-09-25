package ibm.fscc.employee.Data;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@Table(name = "employee", uniqueConstraints=
{@UniqueConstraint(columnNames = {"user_id"})})
public class Employee {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId; // primary and generated


	
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "user_id")
	private UUID userId; // Generate with UUID and unique
	
	@Column(name= "first_name")
	private String firstName; 

	
	@Column(name= "last_name")
	private String lastName;

	
	@Column(name= "employee_address")
	private String address; 

	
	@Column(name= "employee_state")
	private String state;

	@Column(name= "employee_zip")
	private String zip;

	@Column(name= "cell_phone")
	private String cellPhone;

	@Column(name= "home_phone")
	private String homePhone;

	@Column(name = "email")
	private String email; // Unique

}
