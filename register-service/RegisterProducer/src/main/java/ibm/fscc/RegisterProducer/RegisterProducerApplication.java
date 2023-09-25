package ibm.fscc.RegisterProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisterProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterProducerApplication.class, args);
	}

}
