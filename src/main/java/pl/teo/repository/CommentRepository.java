package pl.teo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.entity.Comment;

import javax.persistence.Id;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Id> {
    List<Comment> findAllByOrderByCreatedAsc();
    List<Comment> findAllByUserIdOrderByCreatedAsc(long id);
    List<Comment> findAllByTweetIdOrderByCreatedAsc(long id);
}
