package ibm.fscc.RegisterConsumer;



import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.fscc.RegisterConsumer.Entities.RegisterEvent;
import ibm.fscc.RegisterConsumer.Repositories.RegisterEventRepository;

@Service
public class RegisterConsumer {
      private static final Logger LOGGER = LoggerFactory.getLogger(RegisterConsumer.class);

        @Autowired
      private RegisterEventRepository RegRepo;

     
    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String event) throws JsonParseException, JsonMappingException, IOException{
        LOGGER.info(String.format("Order event received in email service => %s", event.toString()));

        ObjectMapper mapper = new ObjectMapper();

    try {
            RegisterEvent re = mapper.readValue(event, RegisterEvent.class);
            RegRepo.save(re); 
            System.out.println("Event saved: " + re);
      } catch (Exception e) {
            System.err.println("Error processing event: " + e.getMessage());
        } 
    }
}
