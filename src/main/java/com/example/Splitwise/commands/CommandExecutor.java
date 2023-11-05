package com.example.Splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor implements Command{
    private List<Command> commands = new ArrayList<>();
    @Autowired
    public CommandExecutor(SettleUpUser settleUpUser){
        commands.add(settleUpUser);
    }
    public void register(Command command){

    }
    public void removeCommand(Command command){

    }
    @Override
    public boolean match(String input) {
        return false;
    }

    @Override
    public boolean execute(String input) {
        return false;
    }
}
