package com.example.Splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{
    private String description;
    private int amount;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @OneToMany(mappedBy = "expense")
    /*it will just refer the expense in ExpenseUser class and spring won't prepare any column for it
    it understands that just for the code usage we written it nothing to do in database
     */
    private List<ExpenseUser> expenseUserList;
}
