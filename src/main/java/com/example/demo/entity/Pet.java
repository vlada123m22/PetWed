package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Pet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "region")
    private String region;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "breed_id")
    private Integer breedId;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "adding_date")
    private Date addingDate;
    @Basic
    @Column(name = "bio")
    private String bio;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @OneToMany(mappedBy = "petByFromPetId")
    private Collection<Matching> matchingsById;
    @OneToMany(mappedBy = "petByToPetId")
    private Collection<Matching> matchingsById_0;
    @ManyToOne
    @JoinColumn(name = "breed_id", referencedColumnName = "id")
    private Breeds breedsByBreedId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getBreedId() {
        return breedId;
    }

    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (id != pet.id) return false;
        if (nickname != null ? !nickname.equals(pet.nickname) : pet.nickname != null) return false;
        if (city != null ? !city.equals(pet.city) : pet.city != null) return false;
        if (region != null ? !region.equals(pet.region) : pet.region != null) return false;
        if (gender != null ? !gender.equals(pet.gender) : pet.gender != null) return false;
        if (breedId != null ? !breedId.equals(pet.breedId) : pet.breedId != null) return false;
        if (birthDate != null ? !birthDate.equals(pet.birthDate) : pet.birthDate != null) return false;
        if (addingDate != null ? !addingDate.equals(pet.addingDate) : pet.addingDate != null) return false;
        if (bio != null ? !bio.equals(pet.bio) : pet.bio != null) return false;
        if (userId != null ? !userId.equals(pet.userId) : pet.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (breedId != null ? breedId.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (addingDate != null ? addingDate.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public Collection<Matching> getMatchingsById() {
        return matchingsById;
    }

    public void setMatchingsById(Collection<Matching> matchingsById) {
        this.matchingsById = matchingsById;
    }

    public Collection<Matching> getMatchingsById_0() {
        return matchingsById_0;
    }

    public void setMatchingsById_0(Collection<Matching> matchingsById_0) {
        this.matchingsById_0 = matchingsById_0;
    }

    public Breeds getBreedsByBreedId() {
        return breedsByBreedId;
    }

    public void setBreedsByBreedId(Breeds breedsByBreedId) {
        this.breedsByBreedId = breedsByBreedId;
    }
}
