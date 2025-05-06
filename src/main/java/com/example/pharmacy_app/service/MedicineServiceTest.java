package com.example.pharmacy_app.service;


import com.example.pharmacy_app.model.Medicine;
import com.example.pharmacy_app.repository.MedicineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicineServiceTest {
    @Mock
    private MedicineRepository medicineRepository;
    
    @InjectMocks
    private MedicineService medicineService;

    @Test
    void searchMedicines_ShouldReturnMatchingMedicines() {
        // Arrange
        Medicine medicine = new Medicine();
        medicine.setName("Paracetamol");
        when(medicineRepository.findByNameContainingIgnoreCaseOrActiveIngredientContainingIgnoreCase("para", "para"))
            .thenReturn(List.of(medicine));
        
        // Act
        List<Medicine> result = medicineService.searchMedicines("para");
        
        // Assert
        assertEquals(1, result.size());
        assertEquals("Paracetamol", result.get(0).getName());
    }
}
