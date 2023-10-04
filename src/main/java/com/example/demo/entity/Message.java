package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="messages")
public class Message {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
   
    @Column(name = "message")
    private String message;
   
    @Column(name = "message_seen")
    private Byte messageSeen;
   
    @Column(name = "when_sent")
    private Timestamp whenSent;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFromUserId() {
        return fromUser;
    }

    public void setFromUserId(User fromUserId) {
        this.fromUser = fromUserId;
    }

    public User getToUserId() {
        return toUser;
    }

    public void setToUserId(User toUserId) {
        this.toUser = toUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Byte getMessageSeen() {
        return messageSeen;
    }

    public void setMessageSeen(Byte messageSeen) {
        this.messageSeen = messageSeen;
    }

    public Timestamp getWhenSent() {
        return whenSent;
    }

    public void setWhenSent(Timestamp whenSent) {
        this.whenSent = whenSent;
    }

}
