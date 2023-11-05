package com.example.Splitwise.service;

import com.example.Splitwise.Models.Expense;
import com.example.Splitwise.Models.ExpenseUser;
import com.example.Splitwise.Models.Group;
import com.example.Splitwise.Models.User;
import com.example.Splitwise.Repository.ExpenseRepository;
import com.example.Splitwise.Repository.ExpenseUserRepository;
import com.example.Splitwise.Repository.GroupRepository;
import com.example.Splitwise.Repository.UserRepository;
import com.example.Splitwise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    SettleUpStrategy settleUpStrategy;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseUserRepository expenseUserRepository;
    public List<Expense> settleUpUser(Long userId){
        /* 1) get all the expenses which the user is a part of
         2)Iterate over all the expenses and find out of all the people involved
         in those expenses
         3) Use min and max heap to find all the transactions (SettleUp Strategy)
         4) return the transaction

         */
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException();
        }
        User user = userOptional.get();
        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);
        List<Expense> expenses = new ArrayList<>();
        for(ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }
        List<Expense> settleUpTransactions = settleUpStrategy.settleUp(expenses);
        List<Expense> expensesToReturn = new ArrayList<>();
        for(Expense expense : settleUpTransactions){
            for(ExpenseUser expenseUser : expenseUsers){
                if(expenseUser.getUser().equals(user)){
                    expensesToReturn.add(expense);
                    break;
                }
            }
        }
        return expensesToReturn;
    }
    public List<Expense> settleUpGroup(Long groupId){
        /* 1) get all the expenses of the group
         2)Iterate over all the expenses and find out of all the people involved
         in those expenses
         3) Use min and max heap to find all the transactions (SettleUp Strategy)
         4) return the transaction

         */
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if(optionalGroup.isEmpty()){
            throw new RuntimeException();
        }

        Group group = optionalGroup.get();
        List<Expense> expenseList = expenseRepository.findALlByGroup(group);
        List<Expense> expensesToSettleUp = settleUpStrategy.settleUp(expenseList);
        return expensesToSettleUp;
    }
}
