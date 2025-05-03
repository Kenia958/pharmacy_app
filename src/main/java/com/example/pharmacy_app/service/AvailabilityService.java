package com.example.pharmacy_app.service;


import org.springframework.stereotype.Service;

import com.example.pharmacy_app.model.MedicineStock;
import com.example.pharmacy_app.repository.MedicineStockRepository;

import java.util.List;

@Service
public class AvailabilityService {
    private final MedicineStockRepository stockRepository;

    public AvailabilityService(MedicineStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<MedicineStock> checkAvailability(Long medicineId) {
        return stockRepository.findByMedicineIdAndQuantityGreaterThan(medicineId, 0);
    }

    public List<MedicineStock> searchNearbyAvailability(String medicineName, Double latitude, Double longitude, Double radius) {
        // Implémentation simplifiée - dans une vraie app, on utiliserait une requête géospatiale
        return stockRepository.findByMedicineNameContainingIgnoreCaseAndQuantityGreaterThan(medicineName, 0);
    }

    public MedicineStock updateStock(Long Id, MedicineStock medicineStock) {
        MedicineStock stock = stockRepository.findById(Id)
            .orElseThrow(() -> new RuntimeException("Meedicine doesnt exist in stock"));
        stock.setMedicine(medicineStock.getMedicine());
        stock.setPharmacy(medicineStock.getPharmacy());
        stock.setPrice(medicineStock.getPrice());    
        stock.setQuantity(medicineStock.getQuantity());
        return stockRepository.save(stock);
    }
}
