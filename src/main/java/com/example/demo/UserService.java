package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve users by status (active or deactivated)
    public List<User> getUsersByStatus(boolean status) {
        return userRepository.findByStatus(status);
    }
    
 // New method to create a user
    public User saveUser(User user) {
        return userRepository.save(user);  // Save the new user to the database
    }
    // Method to update the status of a user
    // Method to update the status of a user
    public String updateUserStatus(Long id, Boolean status) {
        // Find the user by ID
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Set the new status
        user.setStatus(status);

        // Save the updated user
        userRepository.save(user);

        return "User status updated successfully";
    }    }

