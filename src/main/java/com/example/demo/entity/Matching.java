package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Matching {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "from_pet_id")
    private Integer fromPetId;
    @Basic
    @Column(name = "to_pet_id")
    private Integer toPetId;
    @Basic
    @Column(name = "like_value")
    private Byte likeValue;
    @Basic
    @Column(name = "seen")
    private Byte seen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFromPetId() {
        return fromPetId;
    }

    public void setFromPetId(Integer fromPetId) {
        this.fromPetId = fromPetId;
    }

    public Integer getToPetId() {
        return toPetId;
    }

    public void setToPetId(Integer toPetId) {
        this.toPetId = toPetId;
    }

    public Byte getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(Byte likeValue) {
        this.likeValue = likeValue;
    }

    public Byte getSeen() {
        return seen;
    }

    public void setSeen(Byte seen) {
        this.seen = seen;
    }


}
