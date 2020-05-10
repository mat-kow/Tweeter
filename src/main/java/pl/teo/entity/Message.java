package pl.teo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Message(String text, User receiver, User sender) {
        this.text = text;
        this.receiver = receiver;
        this.sender = sender;
    }

    public Message() {
    }

    private boolean isNew = true;
    @CreationTimestamp
    private Timestamp sent;
    @Column(length = 500)
    @Size(max = 500)
    private String text;
    @ManyToOne
    private User receiver;
    @ManyToOne
    private User sender;

    public long getId() {
        return id;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Timestamp getSent() {
        return sent;
    }

    public void setSent(Timestamp sent) {
        this.sent = sent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
