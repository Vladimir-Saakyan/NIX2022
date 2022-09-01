package com.command;

import lombok.Getter;

@Getter
public enum Action {
    CREATE("create vehicle", new Create()), PRINT("Print vehicles", new Print()), UPDATE("Update vehicle", new Update());

    private final String name;
    private final Command command;
    Action(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public void execute(){
        command.execute();
    }

}
