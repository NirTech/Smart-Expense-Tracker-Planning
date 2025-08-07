package com.nirtech.SmartExpenseTracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "User is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;
}
