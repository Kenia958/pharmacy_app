package com.example.pharmacy_app.controller;


import com.example.pharmacy_app.dto.LoginRequest;
import com.example.pharmacy_app.dto.RegisterRequest;
import com.example.pharmacy_app.model.Pharmacy;
import com.example.pharmacy_app.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.authenticate(
            loginRequest.getEmail(), 
            loginRequest.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<Pharmacy> register(@RequestBody RegisterRequest registerRequest) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setEmail(registerRequest.getEmail());
        pharmacy.setPassword(registerRequest.getPassword());
        pharmacy.setName(registerRequest.getName());
        // Set other fields...
        return ResponseEntity.ok(authService.registerPharmacy(pharmacy));
    }
}
