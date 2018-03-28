package com.tasks5.command;

public class Echo implements Command {
    private String input = "";

    public Echo(String text){
        input = text;
    }
    @Override
    public void execute() {
        System.out.println(input);
    }
}