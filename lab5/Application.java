package com.tasks5.command;

public class Application {
    public static void main(String[] args) {
        Command command;

        if (args == null || args.length == 0){
            command = new Echo("Error");
        } else if (args.length == 1 && args[0].equals("help")){
            command = new Help();
        } else if (args.length == 1 && args[0].equals("exit")){
            command = new Exit();
        } else if (args.length == 2 && args[0].equals("date") && args[1].equals("now")){
            command = new Date();
        } else if (args.length == 2 && args[0].equals("echo")){
            command = new Echo(args[1]);
        } else {
            command = new Echo("Error");
        }

        command.execute();
    }
}