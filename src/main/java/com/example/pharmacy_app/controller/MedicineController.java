package com.example.pharmacy_app.controller;


import org.springframework.web.bind.annotation.*;

import com.example.pharmacy_app.model.Medicine;
import com.example.pharmacy_app.service.MedicineService;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/search")
    public List<Medicine> searchMedicines(@RequestParam String query) {
        return medicineService.searchMedicines(query);
    }

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }
}