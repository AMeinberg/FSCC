package ibm.fscc.RegisterConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisterConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterConsumerApplication.class, args);
	}

}
