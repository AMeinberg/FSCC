package ibm.fscc.RegisterProducer.Entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Register")
public class Register  implements Serializable{
    private String userId;
    private String name;
    private int password;
    private double email;
}
