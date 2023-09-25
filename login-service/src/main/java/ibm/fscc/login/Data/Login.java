package ibm.fscc.login.Data;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter @Setter @ToString
@Table(name = "login")
public class Login {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    public Login(String email, String password) {
        this.userEmail = email;
        this.userPassword = password;
    }
}