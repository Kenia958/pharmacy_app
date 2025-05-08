package com.example.pharmacy_app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pharmacy_app.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Tentative de chargement de l'utilisateur: {}", username);
        
        try {
            User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    logger.error("Utilisateur non trouvé: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });

            logger.info("Utilisateur trouvé: {} avec le rôle: {}", username, user.getRole());
            
            return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
            );
        } catch (Exception e) {
            logger.error("Erreur lors du chargement de l'utilisateur: {} - {}", username, e.getMessage(), e);
            throw e;
        }
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}