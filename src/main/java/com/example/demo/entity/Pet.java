package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
    @Column(name = "nickname")
    private String nickname;
   
    @Column(name = "city")
    private String city;
   
    @Column(name = "region")
    private String region;
   
    @Column(name = "gender")
    private String gender;
   
    @Column(name = "birth_date")
    private Date birthDate;
   
    @Column(name = "adding_date")
    private Date addingDate;
   
    @Column(name = "bio")
    private String bio;

   
    @Column(name="avatar_path")
    private String avatarPath;
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
