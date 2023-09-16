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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usser usser = (Usser) o;

        if (id != usser.id) return false;
        if (familyName != null ? !familyName.equals(usser.familyName) : usser.familyName != null) return false;
        if (surname != null ? !surname.equals(usser.surname) : usser.surname != null) return false;
        if (email != null ? !email.equals(usser.email) : usser.email != null) return false;
        if (pasword != null ? !pasword.equals(usser.pasword) : usser.pasword != null) return false;
        if (city != null ? !city.equals(usser.city) : usser.city != null) return false;
        if (region != null ? !region.equals(usser.region) : usser.region != null) return false;
        if (gender != null ? !gender.equals(usser.gender) : usser.gender != null) return false;
        if (birthDate != null ? !birthDate.equals(usser.birthDate) : usser.birthDate != null) return false;
        if (registrationDate != null ? !registrationDate.equals(usser.registrationDate) : usser.registrationDate != null)
            return false;
        if (bio != null ? !bio.equals(usser.bio) : usser.bio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pasword != null ? pasword.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        return result;
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
