package com.nirtech.SmartExpenseTracker.service;

import com.nirtech.SmartExpenseTracker.entity.User;
import com.nirtech.SmartExpenseTracker.exception.UserNotFoundException;
import com.nirtech.SmartExpenseTracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service // mark it as a service component
public class AuthService {
    //Inject UserRepository via constructor injection.
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //constructor injection
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Register User
    public User registerUser(String username, String password) {
        //check if user already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserNotFoundException("User already exists");
        }
        //create user
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Collections.singletonList("USER"));
        return userRepository.save(user);
    }

    //Login User
    public User loginUser(String username, String password){
        //Check user is present or not
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Username or password"));
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new IllegalArgumentException("Wrong Password");
        }
        return user;
    }
}
