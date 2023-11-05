package com.example.Splitwise.commands;

public interface Command {
    public static final String SETTLE_UP_COMMAND = "SettleUp";
    boolean match(String input);
    boolean execute(String input);
}
