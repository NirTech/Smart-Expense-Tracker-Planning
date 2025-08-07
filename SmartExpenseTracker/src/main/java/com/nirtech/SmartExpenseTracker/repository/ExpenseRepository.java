package com.nirtech.SmartExpenseTracker.repository;

import com.nirtech.SmartExpenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    // This allows finding all expenses for a specific user.
    List<Expense> findByUserId(int userId);
}
