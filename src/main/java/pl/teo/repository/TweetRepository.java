package pl.teo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.entity.Tweet;

import java.util.ArrayList;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    public ArrayList<Tweet> findAllByOrderByCreatedDesc();
    public ArrayList<Tweet> findAllByUserIdOrderByCreatedDesc(long id);
    public Tweet findById (long id);
}
