package com.command;

import com.model.vehicle.*;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.service.VehicleFactory;
import com.util.UserInputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Create implements Command {
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();

    @Override
    public void execute() {
        final VehicleType[] values = VehicleType.values();
        final List<String> names = getNames(values);
        final int userInput = UserInputUtil.getUserInput("What you want to create:", names);
        final VehicleType value = values[userInput];

        switch (value){
            case AUTO -> AUTO_SERVICE.createAndSaveAutos(10);
            case BUS -> BUS_SERVICE.createAndSaveAutos(10);
            case MOTO -> MOTO_SERVICE.createAndSaveAutos(10);
            default -> throw new IllegalArgumentException("Cannot build: " + value);
        }
    }

    private static List<String> getNames(VehicleType[] values) {
        final List<String> names = new ArrayList<>(values.length);
        for (VehicleType type : values){
            names.add(type.name());
        }
        return names;
    }
}
