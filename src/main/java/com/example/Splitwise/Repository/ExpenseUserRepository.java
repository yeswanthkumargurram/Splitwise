package com.example.Splitwise.Repository;

import com.example.Splitwise.Models.ExpenseUser;
import com.example.Splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User userId);
}
