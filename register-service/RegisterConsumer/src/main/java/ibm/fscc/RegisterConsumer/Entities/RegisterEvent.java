package ibm.fscc.RegisterConsumer.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="RegisterEvent")
public class RegisterEvent  implements Serializable{
    private String message;
    private String status;
    private int userId;
    private String name;
    private String password;
    private String email;


    @JsonCreator
    public RegisterEvent(@JsonProperty("message") String message,
                         @JsonProperty("status") String status,
                         @JsonProperty("userId") int userId,
                         @JsonProperty("name") String name,
                         @JsonProperty("password") String password,
                         @JsonProperty("email") String email
                         ) {
        this.message = message;
        this.status = status;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
    }

}