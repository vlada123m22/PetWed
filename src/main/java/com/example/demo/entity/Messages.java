package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Messages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "message_seen")
    private Byte messageSeen;
    @Basic
    @Column(name = "when_sent")
    private Timestamp whenSent;

    @ManyToOne
    @JoinColumn(name = "from_user_id", referencedColumnName = "id")
    private Usser fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id", referencedColumnName = "id")
    private Usser toUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usser getFromUserId() {
        return fromUser;
    }

    public void setFromUserId(Usser fromUserId) {
        this.fromUser = fromUserId;
    }

    public Usser getToUserId() {
        return toUser;
    }

    public void setToUserId(Usser toUserId) {
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
