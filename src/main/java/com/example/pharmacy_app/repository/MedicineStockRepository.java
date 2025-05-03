package com.example.pharmacy_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmacy_app.model.MedicineStock;

import java.util.List;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {
    List<MedicineStock> findByMedicineId(Long medicineId);
    List<MedicineStock> findByPharmacyId(Long pharmacyId);
    List<MedicineStock> findByMedicineNameContainingIgnoreCaseAndQuantityGreaterThan(String medicineName, Integer quantity);
}