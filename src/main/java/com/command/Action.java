package com.command;

import lombok.Getter;

@Getter
public enum Action {
    CREATE("create vehicle", new Create()),
    UPDATE("Update vehicle", new Update()),
    PRINT("Print vehicles", new Print()),
    EXIT("Exit", null);


    private final String name;
    private final Command command;
    Action(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public Command execute(){
        if(command != null) {
            command.execute();
        }
        return command;
    }

}
