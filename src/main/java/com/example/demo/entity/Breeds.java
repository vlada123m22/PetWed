package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Breeds {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "breed")
    private String breed;
    @Basic
    @Column(name = "parent_breed_id")
    private Integer parentBreedId;
    @ManyToOne
    @JoinColumn(name = "parent_breed_id", referencedColumnName = "id")
    private Breeds breedsByParentBreedId;
    @OneToMany(mappedBy = "breedsByParentBreedId")
    private Collection<Breeds> breedsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getParentBreedId() {
        return parentBreedId;
    }

    public void setParentBreedId(Integer parentBreedId) {
        this.parentBreedId = parentBreedId;
    }



    public Breeds getBreedsByParentBreedId() {
        return breedsByParentBreedId;
    }

    public void setBreedsByParentBreedId(Breeds breedsByParentBreedId) {
        this.breedsByParentBreedId = breedsByParentBreedId;
    }

    public Collection<Breeds> getBreedsById() {
        return breedsById;
    }

    public void setBreedsById(Collection<Breeds> breedsById) {
        this.breedsById = breedsById;
    }
}
