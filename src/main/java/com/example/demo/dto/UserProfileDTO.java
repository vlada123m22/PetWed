package com.celac.ecommerce.dto;

import java.time.LocalDateTime;

/**
* @author scelac
*/
public class UserProfileDTO {
    private Long userId;
    private String userName;
    private String imgPath;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    public UserProfileDTO() {
    }

    public UserProfileDTO(Long userId, String userName, String firstName, String lastName, String imgPath,  String address, String phoneNumber, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        this.userId = userId;
        this.userName = userName;
        this.imgPath = imgPath;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
