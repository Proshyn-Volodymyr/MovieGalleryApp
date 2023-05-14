package com.gmail.vladimirprocean.moviegalleryapp.config;

import com.gmail.vladimirprocean.moviegalleryapp.util.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private UserDetailsService userDetailsService;
    private CustomPasswordEncoder customPasswordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, CustomPasswordEncoder customPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return customPasswordEncoder.getPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .userDetailsService(userDetailsService)
                .csrf().disable()
                .build();
    }

}
