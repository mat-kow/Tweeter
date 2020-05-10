package pl.teo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.entity.Message;

import javax.persistence.Id;
import java.util.ArrayList;

public interface MessageRepository extends JpaRepository<Message, Id> {
    ArrayList<Message> findAllByReceiverIdOrderBySentDesc(long receiverId);
    ArrayList<Message> findAllBySenderIdOrderBySentDesc(long senderId);
    Message findById(long id);
}
