package com.gmail.vladimirprocean.moviegalleryapp.service;

import com.gmail.vladimirprocean.moviegalleryapp.model.User;
import com.gmail.vladimirprocean.moviegalleryapp.util.CustomPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private CustomPasswordEncoder customPasswordEncoder;

    public UserDetailsServiceImpl() {
        this.customPasswordEncoder = new CustomPasswordEncoder();
    }

    //    Talking with the repository to know does our user exist
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUserName(username);
        user.setPassword(customPasswordEncoder.getPasswordEncoder().encode("password"));
        user.setId(1L);
        return user;
    }
}
