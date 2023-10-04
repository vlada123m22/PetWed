package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="matching")
public class Matching {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "like_value")
    private Byte likeValue;
    
    @Column(name = "seen")
    private Byte seen;

    @ManyToOne
    @JoinColumn(name = "from_pet_id", referencedColumnName = "id")
    private Pet fromPet;

    @ManyToOne
    @JoinColumn(name = "to_pet_id", referencedColumnName = "id")
    private Pet toPet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Pet getFromPet() {
        return fromPet;
    }

    public void setFromPet(Pet fromPet) {
        this.fromPet = fromPet;
    }

    public Pet getToPet() {
        return toPet;
    }

    public void setToPet(Pet toPet) {
        this.toPet = toPet;
    }
}
