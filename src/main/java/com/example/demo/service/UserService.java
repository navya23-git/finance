package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.entity.Role;
import com.example.demo.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    // Create new user
    public User createUser(User user){
        user.setActive(true); // default active
        return repository.save(user);
    }

    // Get all users
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    // Update user info
    public User updateUser(Long id, User updated){
        User existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setRole(updated.getRole());
        return repository.save(existing);
    }

    // Activate / Deactivate user
    public User setActiveStatus(Long id, boolean status){
        User existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setActive(status);
        return repository.save(existing);
    }

    // Find by email
    public User findByEmail(String email){
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}