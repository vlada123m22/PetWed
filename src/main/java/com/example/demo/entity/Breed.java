package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="breeds")
public class Breed {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Column(name = "breed")
    private String breed;
    
    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
