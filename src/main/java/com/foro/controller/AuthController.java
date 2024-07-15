package com.foro.controller;

import com.foro.model.User;
import com.foro.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody User user) {
        // Verifica si el usuario ya existe
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // Hashea la contraseña antes de guardarla
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guarda el usuario en la base de datos
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
