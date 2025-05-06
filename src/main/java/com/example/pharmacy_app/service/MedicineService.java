package com.example.pharmacy_app.service;


import org.springframework.stereotype.Service;

import com.example.pharmacy_app.model.Medicine;
import com.example.pharmacy_app.repository.MedicineRepository;

import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> searchMedicines(String query) {
        return medicineRepository.findByNameContainingIgnoreCase(query);
    }

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
    
}