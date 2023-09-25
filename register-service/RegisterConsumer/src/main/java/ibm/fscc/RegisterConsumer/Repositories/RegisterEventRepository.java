package ibm.fscc.RegisterConsumer.Repositories;


import org.springframework.data.mongodb.repository.MongoRepository;


import ibm.fscc.RegisterConsumer.Entities.RegisterEvent;


public interface RegisterEventRepository  extends MongoRepository<RegisterEvent, Long> {
    
}