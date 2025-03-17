package com.saveetha.LeaveManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for testing
                .cors(cors -> cors.disable())  // Disable CORS if needed
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()  // Allow authentication APIs
                        .requestMatchers("/api/departments/create", "/api/departments/update/**", "/api/departments/delete/**").hasAuthority("ROLE_ADMIN")  // Only admins can manage departments
                        .requestMatchers("/api/departments/all").permitAll()
                        .requestMatchers("/api/employees/update-profile").hasAuthority("ROLE_EMPLOYEE")// Anyone can view departments
                        .anyRequest().authenticated()  // Secure all other endpoints
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Ensure stateless session for JWT authentication

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
