package com.service;

import com.model.vehicle.Bus;
import com.model.vehicle.Manufacturer;
import com.repository.BusRepiository;
import com.repository.CrudRepo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BusService extends Service<Bus> {

    private static BusService instance;

    private BusService(CrudRepo<Bus> repository){
        super(repository);
    }

    public static BusService getInstance(){
        if(instance == null){
            instance = new BusService(BusRepiository.getInstance());
        }
        return instance;
    }

    @Override
    protected Bus create() {
        return new Bus(
                "Model Bus -" + RANDOM.nextInt(1000),
                getRandomManufacturer(),
                BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                "Model Bus-" + RANDOM.nextInt(1000),
                RANDOM.nextInt(10), LocalTime.now()
        );
    }
    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }
}
