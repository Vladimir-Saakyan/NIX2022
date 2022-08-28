package com.service;

import com.model.vehicle.Bus;
import com.model.vehicle.Manufacturer;
import com.repository.CrudRepo;

import java.math.BigDecimal;

public class BusService extends Service<Bus> {

    public BusService(CrudRepo<Bus> repository){
        super(repository);
    }

    @Override
    protected Bus create() {
        return new Bus(
                "Model Bus -" + RANDOM.nextInt(1000),
                getRandomManufacturer(),
                BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                "Model Bus-" + RANDOM.nextInt(1000)
        );
    }
    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }
}
