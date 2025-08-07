package com.nirtech.SmartExpenseTracker.repository;

import com.nirtech.SmartExpenseTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    // Why Optional<User>? → Avoids NullPointerException when user not found.
    Optional<User> findByUsername(String username);
}
