package com.gmail.vladimirprocean.moviegalleryapp.service;

import com.gmail.vladimirprocean.moviegalleryapp.auth.AuthenticationRequest;
import com.gmail.vladimirprocean.moviegalleryapp.auth.AuthenticationResponse;
import com.gmail.vladimirprocean.moviegalleryapp.auth.RegisterRequest;
import com.gmail.vladimirprocean.moviegalleryapp.model.Role;
import com.gmail.vladimirprocean.moviegalleryapp.model.User;
import com.gmail.vladimirprocean.moviegalleryapp.repository.UserRepository;
import com.gmail.vladimirprocean.moviegalleryapp.util.CustomPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final CustomPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, CustomPasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setUserName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.getPasswordEncoder().encode(request.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findUserByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
