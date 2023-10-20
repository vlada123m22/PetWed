package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="likes")
public class Like {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "like_value")
    private Boolean likeValue;

    @ManyToOne
    @JoinColumn(name = "from_pet_id")
    private Pet fromPet;

    @ManyToOne
    @JoinColumn(name = "to_pet_id")
    private Pet toPet;

    public Like() {
    }

    public Like(Boolean likeValue, Pet fromPet, Pet toPet) {
        this.likeValue = likeValue;
        this.fromPet = fromPet;
        this.toPet = toPet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(Boolean likeValue) {
        this.likeValue = likeValue;
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
