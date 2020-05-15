package pl.teo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Tweet {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @NotNull
    private User user;
    @NotNull
    @Size(min = 1, max = 140)
    @Column(length = 140)
    private String tweetContent;
    @CreationTimestamp
    private Timestamp created;

    public Tweet(@NotNull User user, @NotNull @Size(min = 1, max = 140) String tweetContent) {
        this.user = user;
        this.tweetContent = tweetContent;
    }

    public Tweet() {
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
