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
