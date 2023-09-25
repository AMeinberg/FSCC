package ibm.fscc.RegisterProducer;


import java.io.StringBufferInputStream;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import ibm.fscc.RegisterProducer.Entities.RegisterEvent;

@Service
public class RegisterProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterProducer.class);

    @Autowired
    private NewTopic topic;

    private KafkaTemplate<String, RegisterEvent> kafkaTemplate;

    public RegisterProducer(NewTopic topic, KafkaTemplate<String, RegisterEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String event){
        LOGGER.info(String.format("Order event => %s", event.toString()));

        // create Message
        Message<String> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}


