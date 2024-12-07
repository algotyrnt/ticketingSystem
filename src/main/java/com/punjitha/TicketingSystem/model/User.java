package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String userName = "systemUser";
    private String email = "systemUser@punjitha.com";

    public User() {
    }

    public void getUserId() {
    }

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", userName=" + this.getUserName() + ", email=" + this.getEmail() + ")";
    }

    public Long getId() {
        return this.id;
    }
}
