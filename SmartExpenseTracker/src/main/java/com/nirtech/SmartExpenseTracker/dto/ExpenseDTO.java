package com.nirtech.SmartExpenseTracker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @Min(value = 1, message = "Amount must be greater than 0")
    private float amount;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotBlank(message = "Category is required")
    private String category;
}
