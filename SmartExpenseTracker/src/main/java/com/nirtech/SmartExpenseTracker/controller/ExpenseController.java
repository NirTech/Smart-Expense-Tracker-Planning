package com.nirtech.SmartExpenseTracker.controller;

import com.nirtech.SmartExpenseTracker.dto.ExpenseDTO;
import com.nirtech.SmartExpenseTracker.dto.ExpenseResponseDTO;
import com.nirtech.SmartExpenseTracker.entity.Expense;
import com.nirtech.SmartExpenseTracker.entity.User;
import com.nirtech.SmartExpenseTracker.exception.UserNotFoundException;
import com.nirtech.SmartExpenseTracker.repository.UserRepository;
import com.nirtech.SmartExpenseTracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final UserRepository userRepository;

    public ExpenseController(ExpenseService expenseService, UserRepository userRepository) {
        this.expenseService = expenseService;
        this.userRepository = userRepository;
    }
    //add Expense
    @PostMapping("/{userId}")
    public ResponseEntity<ExpenseResponseDTO> addExpense(@Valid @RequestBody ExpenseDTO expenseDTO, @PathVariable int userId, Authentication authentication){
        enforceUserOwnership(userId, authentication);
        Expense savedExpense = expenseService.addExpense(expenseDTO,userId);
        return ResponseEntity.status(201).body(new ExpenseResponseDTO(savedExpense.getId(), savedExpense.getTitle(), savedExpense.getAmount(), savedExpense.getDate(), savedExpense.getCategory(), savedExpense.getUser().getUsername()));
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<Expense> updateExpense(@Valid @RequestBody ExpenseDTO expenseDTO, @PathVariable int expenseId){
        Expense savedExpense = expenseService.updateExpense(expenseId,expenseDTO);
        return ResponseEntity.ok(savedExpense);
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable int expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUser(@PathVariable int userId){
        List<Expense> expenseList = expenseService.getExpensesByUser(userId);
        return  ResponseEntity.ok().body(expenseList);
    }

    // ✅ Helper: Check if logged-in user matches requested userId
    private void enforceUserOwnership(int userId, Authentication authentication) {
        String loggedInUsername = authentication.getName();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        if (!loggedInUsername.equals(user.getUsername())) {
            throw new AccessDeniedException("Access Denied: You cannot modify another user's data");
        }
    }
}
