package com.command;

import com.util.binaryThree.Run;
import com.util.streamchik.Streamchiki;
import lombok.Getter;

@Getter
public enum Action {
    CREATE("create vehicle", new Create()),
    UPDATE("Update vehicle", new Update()),
    DELETE("Delete vehicle", new Delete()),
    PRINT("Print vehicles", new Print()),
    PRINTALL("Print all vehicles", new PrintAll()),
    RUNTREE("Run trees", new Run()),

    STREAMHW("Stream", new Streamchiki()),
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
