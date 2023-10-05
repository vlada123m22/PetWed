package com.example.demo.entity.enums;

public enum RoleName {
    GUEST("GUEST"),
    ADMIN("ADMIN"),
    REGISTERED("REGISTERED");
    private String role;

    RoleName(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
