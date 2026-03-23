package org.example.springsec.controller;

import org.example.springsec.entities.Users;
import org.example.springsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        System.out.println(user);
        return userService.verify(user);
    }
}
