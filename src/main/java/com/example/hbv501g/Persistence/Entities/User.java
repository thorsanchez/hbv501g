package com.example.hbv501g.Persistence.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    private String username;
    private String passwoed;
    private String email;


}
