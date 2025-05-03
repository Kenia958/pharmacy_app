package com.example.pharmacy_app.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String activeIngredient;
    private String dosage;
    private String form; // tablet, syrup, etc.
}
