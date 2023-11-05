package com.example.Splitwise.Repository;

import com.example.Splitwise.Models.Expense;
import com.example.Splitwise.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findALlByGroup(Group group);
}
