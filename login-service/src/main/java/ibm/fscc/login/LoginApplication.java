package ibm.fscc.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.core.SpringVersion;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScans({ @ComponentScan("ibm.fscc.login.Controller")})
@EnableJpaRepositories("ibm.fscc.login.Repository")
@EntityScan("ibm.fscc.login.Data")
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		//System.out.println(SpringVersion.getVersion());
	}

}
