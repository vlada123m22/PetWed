package com.example.demo.dto;

public class AddNewUserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordForCheck;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordForCheck() {
        return passwordForCheck;
    }

    public void setPasswordForCheck(String passwordForCheck) {
        this.passwordForCheck = passwordForCheck;
    }
}
