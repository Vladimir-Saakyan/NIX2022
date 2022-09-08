package com;

import com.command.Action;
import com.command.Command;
import com.model.vehicle.*;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.util.Container;
import com.util.Garage;
import com.util.UserInputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();
    private static Container container = new Container();
    private static Garage<Vehicle> garage = new Garage<Vehicle>();

    private static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("==============================hw15==========================================");
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


