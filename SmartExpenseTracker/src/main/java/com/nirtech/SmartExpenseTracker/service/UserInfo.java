package com.nirtech.SmartExpenseTracker.service;

import com.nirtech.SmartExpenseTracker.dto.UserResponseDTO;
import com.nirtech.SmartExpenseTracker.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserInfo {
    private UserRepository userRepository;

    public UserInfo(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserResponseDTO getUserInfo(String username){

        return userRepository.findByUsername(username)
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername()))
                .orElse(null);
    }
}
