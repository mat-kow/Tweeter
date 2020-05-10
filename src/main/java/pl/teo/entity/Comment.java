package pl.teo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Tweet tweet;
    @ManyToOne
    private User user;
    @CreationTimestamp
    private Timestamp created;
    @Size(min = 1, max = 60)
    @Column(length = 60)
    private String text;

    public Comment(Tweet tweet, User user, @Size(min = 1, max = 41) String text) {
        this.tweet = tweet;
        this.user = user;
        this.text = text;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
