package com.example.pharmacy_app.controller;


import org.springframework.web.bind.annotation.*;

import com.example.pharmacy_app.model.MedicineStock;
import com.example.pharmacy_app.service.AvailabilityService;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping("/medicine/{medicineId}")
    public List<MedicineStock> checkMedicineAvailability(@PathVariable Long medicineId) {
        return availabilityService.checkAvailability(medicineId);
    }

    @GetMapping("/search")
    public List<MedicineStock> searchNearby(
            @RequestParam String medicineName,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon,
            @RequestParam(required = false, defaultValue = "5") Double radius) {
        return availabilityService.searchNearbyAvailability(medicineName, lat, lon, radius);
    }

    @PostMapping("/update-stock")
    public MedicineStock updateStock(
            @RequestParam Long Id,
            @RequestParam MedicineStock medicineStock) {
        return availabilityService.updateStock(Id, medicineStock);
    }
}