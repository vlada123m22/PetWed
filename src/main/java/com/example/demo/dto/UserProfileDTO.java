package com.example.demo.dto;

import java.time.LocalDateTime;

public class UserProfileDTO {
    private Long userId;
    private String userName;
    private String imgPath;
    private String firstName;
    private String lastName;
    private String region;
    private String city;
    private LocalDateTime createdDateTime;

    public UserProfileDTO() {
    }

    public UserProfileDTO(Long userId, String userName, String firstName, String lastName, String imgPath, String region, String city,  LocalDateTime createdDateTime) {
        this.userId = userId;
        this.userName = userName;
        this.imgPath = imgPath;
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.city = city;
        this.createdDateTime = createdDateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

}
