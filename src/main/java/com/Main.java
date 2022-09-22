package com;

import com.command.Action;
import com.command.Command;
import com.util.UserInputUtil;

import java.util.*;


public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {

        final Action[] actions = Action.values();
        final List<String> names = getNames(actions);

        Command command;
        do {
            command = executeCommand(actions, names);
        } while (command != null);
    }

    private static Command executeCommand(Action[] actions, List<String> names){
        int userInput = UserInputUtil.getUserInput("What you want: ", names);
        final Action action = actions[userInput];
        return action.execute();
    }

    private static List<String> getNames(Action[] actions) {
        final List<String> names = new ArrayList<>(actions.length);
        for (Action action : actions) {
            names.add(action.getName());
        }
        return names;
    }
}


