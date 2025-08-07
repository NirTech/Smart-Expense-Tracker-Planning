package com.nirtech.SmartExpenseTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExpenseResponseDTO{
    private int id;
    private String title;
    private float amount;
    private LocalDate date;
    private String category;
    private String username;
}
