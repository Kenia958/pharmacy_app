package com.example.pharmacy_app.controller;


import org.springframework.web.bind.annotation.*;

import com.example.pharmacy_app.model.Pharmacy;
import com.example.pharmacy_app.service.PharmacyService;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping("/register")
    public Pharmacy registerPharmacy(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.registerPharmacy(pharmacy);
    }

    @PutMapping("/{id}")
    public Pharmacy updatePharmacy(@PathVariable Long id, @RequestBody Pharmacy pharmacy) {
        return pharmacyService.updatePharmacy(id, pharmacy);
    }

}