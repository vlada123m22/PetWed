package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Usser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "family_name")
    private String familyName;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "pasword")
    private String pasword;
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
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "registration_date")
    private Date registrationDate;
    @Basic
    @Column(name = "bio")
    private String bio;
    @OneToMany(mappedBy = "usserByFromUserId")
    private Collection<Messages> messagesById;
    @OneToMany(mappedBy = "usserByToUserId")
    private Collection<Messages> messagesById_0;
    @OneToMany(mappedBy = "usserByUserId")
    private Collection<Pet> petsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public Collection<Messages> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<Messages> messagesById) {
        this.messagesById = messagesById;
    }

    public Collection<Messages> getMessagesById_0() {
        return messagesById_0;
    }

    public void setMessagesById_0(Collection<Messages> messagesById_0) {
        this.messagesById_0 = messagesById_0;
    }

    public Collection<Pet> getPetsById() {
        return petsById;
    }

    public void setPetsById(Collection<Pet> petsById) {
        this.petsById = petsById;
    }
}
