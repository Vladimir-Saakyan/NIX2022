package com.command;

import com.model.vehicle.*;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.service.VehicleFactory;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Create implements Command {
    private static final VehicleFactory VEHICLE_FACTORY = VehicleFactory.getInstance();
    private static final AutoService AUTO_SERVICE = new AutoService(new AutoRepository());
    private static final BusService BUS_SERVICE = new BusService(new BusRepiository());
    private static final MotoService MOTO_SERVICE = new MotoService(new MotoRepository());
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void execute() {
        final VehicleType[] values = VehicleType.values();
        int userInput = -1;
        do {
            System.out.println("What you want to create:");
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d %s%n", i, values[i]);
            }
            userInput = SCANNER.nextInt();
        } while (userInput< 0 || userInput >= values.length);
        final Vehicle vehicle = VEHICLE_FACTORY.build(values[userInput]);
        AUTO_SERVICE.save((List<Auto>) vehicle);
        System.out.println("Vehicle" + vehicle + "created" );
//        BUS_SERVICE.save(Collections.singletonList((Bus) vehicle));
        System.out.println("Vehicle" + vehicle + "created" );
//        MOTO_SERVICE.saveAutos(Collections.singletonList((Moto) vehicle));
//        System.out.println("Vehicle" + vehicle + "created" );
    }
}
