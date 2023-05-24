package com.gmail.vladimirprocean.moviegalleryapp.config;

import com.gmail.vladimirprocean.moviegalleryapp.service.UserDetailsServiceImpl;
import com.gmail.vladimirprocean.moviegalleryapp.util.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
@Configuration
public class ApplicationConfig {
    private final UserDetailsServiceImpl userDetailsService;
    private final CustomPasswordEncoder customPasswordEncoder;

    public ApplicationConfig(UserDetailsServiceImpl userDetailsService, CustomPasswordEncoder customPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.customPasswordEncoder = customPasswordEncoder;
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(customPasswordEncoder.getPasswordEncoder());
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
