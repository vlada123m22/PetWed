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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Breeds breeds = (Breeds) o;

        if (id != breeds.id) return false;
        if (breed != null ? !breed.equals(breeds.breed) : breeds.breed != null) return false;
        if (parentBreedId != null ? !parentBreedId.equals(breeds.parentBreedId) : breeds.parentBreedId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        result = 31 * result + (parentBreedId != null ? parentBreedId.hashCode() : 0);
        return result;
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
