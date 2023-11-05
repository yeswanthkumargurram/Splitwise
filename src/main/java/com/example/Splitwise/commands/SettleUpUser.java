package com.example.Splitwise.commands;
import com.example.Splitwise.controller.ExpenseController;
import com.example.Splitwise.dtos.SettleUpUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class SettleUpUser implements Command{
    @Autowired
    ExpenseController expenseController;


    @Override
    public boolean match(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==2 && words.get(1).equalsIgnoreCase(Command.SETTLE_UP_COMMAND);

    }

    @Override
    public boolean execute(String input) {
        SettleUpUserRequestDto userRequestDto = new SettleUpUserRequestDto();
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(1));
        userRequestDto.setUserId(userId);
        expenseController.settleUpUser(userRequestDto);

        return false;
    }
}
