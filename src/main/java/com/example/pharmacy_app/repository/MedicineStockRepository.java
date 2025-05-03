package com.example.pharmacy_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmacy_app.model.MedicineStock;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {
    List<MedicineStock> findByMedicineId(Long medicineId);
    Optional<MedicineStock> findById(Long id);
    List<MedicineStock> findByPharmacyId(Long pharmacyId);
    List<MedicineStock> findByMedicineNameContainingIgnoreCaseAndQuantityGreaterThan(String medicineName, Integer quantity);
    List<MedicineStock> findByMedicineIdAndQuantityGreaterThan(Long medicineId, int i);
    Object findByPharmacyIdAndMedicineId(Long pharmacyId, Long medicineId);

}