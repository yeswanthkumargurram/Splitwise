package com.example.Splitwise.strategies;

import com.example.Splitwise.Models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenseList);
}
