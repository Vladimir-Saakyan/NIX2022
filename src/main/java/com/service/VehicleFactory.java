package com.service;

import com.model.vehicle.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class VehicleFactory {
    private static VehicleFactory instance;
    protected static  final Random RANDOM = new Random();

    private VehicleFactory() {
    }

    public static VehicleFactory getInstance(){
        if(instance == null){
            instance = new VehicleFactory();
        }
        return new VehicleFactory();
    }

    public Vehicle build(VehicleType type){
        return switch (type){
            case BUS -> new Bus(
                    "Model Bus -" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model Bus-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(10), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            );
            case AUTO -> new Auto(
                    "Model-" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(10), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            );

            case MOTO -> new Moto(
                    "Model Moto -" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model MOto-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(10), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            );
            default -> throw new IllegalArgumentException("Cannot build" + type);
        };
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }
}
