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
    @Column(name = "from_user_id")
    private Integer fromUserId;
    @Basic
    @Column(name = "to_user_id")
    private Integer toUserId;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "message_seen")
    private Byte messageSeen;
    @Basic
    @Column(name = "when_sent")
    private Timestamp whenSent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messages messages = (Messages) o;

        if (id != messages.id) return false;
        if (fromUserId != null ? !fromUserId.equals(messages.fromUserId) : messages.fromUserId != null) return false;
        if (toUserId != null ? !toUserId.equals(messages.toUserId) : messages.toUserId != null) return false;
        if (message != null ? !message.equals(messages.message) : messages.message != null) return false;
        if (messageSeen != null ? !messageSeen.equals(messages.messageSeen) : messages.messageSeen != null)
            return false;
        if (whenSent != null ? !whenSent.equals(messages.whenSent) : messages.whenSent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fromUserId != null ? fromUserId.hashCode() : 0);
        result = 31 * result + (toUserId != null ? toUserId.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (messageSeen != null ? messageSeen.hashCode() : 0);
        result = 31 * result + (whenSent != null ? whenSent.hashCode() : 0);
        return result;
    }
}
