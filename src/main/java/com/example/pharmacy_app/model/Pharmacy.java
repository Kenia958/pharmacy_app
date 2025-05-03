package com.example.pharmacy_app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private String phone;
    
    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    private List<MedicineStock> stocks;
}