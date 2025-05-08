package com.example.pharmacy_app.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String phone;
    
    @Column(nullable = false)
    private String role; 
    
    @Column(nullable = false)
    private String address;
}
