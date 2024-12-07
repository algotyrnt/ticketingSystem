package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @Getter
    private Long id;

    private String userName = "systemUser";
    private String email = "systemUser@punjitha.com";
}
