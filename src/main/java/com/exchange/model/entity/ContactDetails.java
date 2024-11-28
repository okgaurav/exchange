package com.exchange.model.entity;

public class ContactDetails {
    private String name;
    private String role;
    private String email;

    public String getName() {
        return name;
    }

    public ContactDetails setName(String name) {
        this.name = name;
        return this;
    }

    public String getRole() {
        return role;
    }

    public ContactDetails setRole(String role) {
        this.role = role;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactDetails setEmail(String email) {
        this.email = email;
        return this;
    }
}
