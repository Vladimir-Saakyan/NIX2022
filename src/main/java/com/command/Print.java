package com.command;

import com.model.vehicle.VehicleType;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.util.UserInputUtil;

import java.util.ArrayList;
import java.util.List;

public class Print implements Command{
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();
    @Override
    public void execute() {
        final VehicleType[] values = VehicleType.values();
        final List<String> names = getNames(values);
        final int userInput = UserInputUtil.getUserInput("What you want to print:", names);
        final VehicleType value = values[userInput];

        switch (value){
            case AUTO -> AUTO_SERVICE.printAll();
            case BUS -> BUS_SERVICE.printAll();
            case MOTO -> MOTO_SERVICE.printAll();
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
