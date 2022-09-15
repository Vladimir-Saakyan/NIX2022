package com.util.streamchik;

import com.command.Command;
import com.model.vehicle.Vehicle;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.util.UserInputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streamchiki implements Command {
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();
    private static final FindAndPrintCar FIND_AND_PRINT_CAR = new FindAndPrintCar();

    @Override
    public void execute() {
        final TypeStream[] values = TypeStream.values();
        final List<String> names = getNames(values);
        final int userInput = UserInputUtil.getUserInput("Change: ", names);
        final TypeStream value = values[userInput];

        switch (value){
            case GETCAR-> FIND_AND_PRINT_CAR.PrintCarByXPrice();
            case SUMPRICE-> FIND_AND_PRINT_CAR.sumPrices();
            case SORTBYNAME -> FIND_AND_PRINT_CAR.sortVehicle();
            case REMOVEDUBL->FIND_AND_PRINT_CAR.removeDyblic();
            case STATISTICBYPRICE -> FIND_AND_PRINT_CAR.statistic();
        }
    }

    private static List<String> getNames(TypeStream[] values) {
        final List<String> names = new ArrayList<>(values.length);
        for (TypeStream type : values){
            names.add(type.name());
        }
        return names;
    }


}
