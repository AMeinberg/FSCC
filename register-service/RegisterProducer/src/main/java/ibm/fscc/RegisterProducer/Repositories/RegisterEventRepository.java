package ibm.fscc.RegisterProducer.Repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ibm.fscc.RegisterProducer.Entities.RegisterEvent;
import java.util.List;



public interface RegisterEventRepository  extends MongoRepository<RegisterEvent, Long> {
    List<RegisterEvent> findByStatus(String status);
    List<RegisterEvent> findByEmail(String email);
}