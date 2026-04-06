package com.example.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails viewer = User.withDefaultPasswordEncoder()
                .username("viewer")
                .password("viewer123")
                .roles("VIEWER")
                .build();

        UserDetails analyst = User.withDefaultPasswordEncoder()
                .username("analyst")
                .password("analyst123")
                .roles("ANALYST")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(viewer, analyst, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/dashboard/**").hasAnyRole("VIEWER","ANALYST","ADMIN")
                .requestMatchers("/records/**").hasAnyRole("ANALYST","ADMIN")
                .requestMatchers("/users/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(); // Use Basic Auth for REST APIs

        return http.build();
    }
}
