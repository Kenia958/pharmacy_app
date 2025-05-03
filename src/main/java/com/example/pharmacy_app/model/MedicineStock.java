package com.example.pharmacy_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MedicineStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Pharmacy pharmacy;
    
    @ManyToOne
    private Medicine medicine;
    
    private Integer quantity;
    private Double price;
}
