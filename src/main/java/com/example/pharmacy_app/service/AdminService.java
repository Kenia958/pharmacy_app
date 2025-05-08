package com.example.pharmacy_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pharmacy_app.model.User;
import com.example.pharmacy_app.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
@Transactional
public class AdminService {
    @Autowired
    private UserRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostConstruct  // Cette méthode sera exécutée après l'initialisation du bean
    public void initAdmin() {
        // Vérifie si un admin existe déjà
        if (adminRepository.findByUsername("admin").isEmpty()) {
            User Admin = new User();
            Admin.setUsername("admin");
            Admin.setName("Rumariza Blaze");
            Admin.setPassword(passwordEncoder.encode("admin123"));
            Admin.setAddress("Kigobe");
            Admin.setPhone("+257 61 30 70 79");
            Admin.setRole("ADMIN");
            Admin.setEmail("blazerumariza2004@gmail.com");
            adminRepository.save(Admin);
            System.out.println("✅ Admin account has beeen created");
        }else {
            System.out.println("The Admin is Already Exist");
        }
    }
}
