package com.example.Splitwise.strategies;

import com.example.Splitwise.Models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{

    @Override
    public List<Expense> settleUp(List<Expense> expenseList) {
        return null;
    }
}
