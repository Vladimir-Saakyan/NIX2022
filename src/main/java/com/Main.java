package com;

import com.command.Action;
import com.command.Command;
import com.model.vehicle.*;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.util.Container;
import com.util.Garage;
import com.util.UserInputUtil;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;

import static java.time.LocalTime.*;

public class Main {
    private static final AutoService AUTO_SERVICE = new AutoService(new AutoRepository());
    private static final BusService BUS_SERVICE = new BusService(new BusRepiository());
    private static final MotoService MOTO_SERVICE = new MotoService(new MotoRepository());
    private static Container container = new Container();
    private static Garage<Vehicle> garage = new Garage<Vehicle>();


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


