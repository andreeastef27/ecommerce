package com.example.ecommerce.security;

import com.example.ecommerce.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private UserRepo userRepo;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER", "ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole("ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN"))
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        List<com.example.ecommerce.model.User> users = userRepo.findAll();
        users.forEach(u -> uds.createUser(User.withUsername(u.getUsername())
                .password(passwordEncoder().encode(u.getPassword()))
                .roles(u.getRole())
                .build()));
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
