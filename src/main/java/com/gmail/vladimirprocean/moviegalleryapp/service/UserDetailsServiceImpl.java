package com.gmail.vladimirprocean.moviegalleryapp.service;

import com.gmail.vladimirprocean.moviegalleryapp.model.User;
import com.gmail.vladimirprocean.moviegalleryapp.repository.UserRepository;
import com.gmail.vladimirprocean.moviegalleryapp.util.CustomPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private CustomPasswordEncoder customPasswordEncoder;
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.customPasswordEncoder = new CustomPasswordEncoder();
        this.userRepository = userRepository;
    }

    //    Talking with the repository to know does our user exist
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUserByUsername(username);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}
