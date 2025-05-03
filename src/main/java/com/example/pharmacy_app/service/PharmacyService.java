package com.example.pharmacy_app.service;


import org.springframework.stereotype.Service;

import com.example.pharmacy_app.model.Pharmacy;
import com.example.pharmacy_app.repository.PharmacyRepository;

@Service
public class PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public Pharmacy registerPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy updatePharmacy(Long id, Pharmacy pharmacyDetails) {
        Pharmacy pharmacy = pharmacyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pharmacy not found"));
        // Update fields
        return pharmacyRepository.save(pharmacy);
    }
}