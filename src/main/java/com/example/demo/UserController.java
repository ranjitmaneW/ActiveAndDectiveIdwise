package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to get users by active (true) or deactive (false) status
    @GetMapping("/status")
    public List<User> getUsersByStatus(@RequestParam boolean status) {
        return userService.getUsersByStatus(status);
    }
    
 // New POST endpoint to create a new user
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);  // Call service method to save user
    }
    @PutMapping("/status/{id}")
    public String updateUserStatus(@PathVariable("id") Long id, @RequestParam Boolean status) {
       
        		System.out.println(id);
        		return userService.updateUserStatus(id, status);
    }
}