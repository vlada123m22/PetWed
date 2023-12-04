package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="chats")
public class Chat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="when_created")
    Timestamp whenCreated;

    @Column(name="last_updated")
    Timestamp lastUpdated;

    @ManyToOne
    @JoinColumn(name="participant1_id")
    User participant1;

    @ManyToOne
    @JoinColumn(name="participant2_id")
    User participant2;

    public Chat(){};
    public Chat(User participant1, User participant2) {
        this.participant1=participant1;
        this.participant2=participant2;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getParticipant1() {
        return participant1;
    }

    public void setParticipant1(User participant1) {
        this.participant1 = participant1;
    }

    public User getParticipant2() {
        return participant2;
    }

    public void setParticipant2(User participant2) {
        this.participant2 = participant2;
    }
}
