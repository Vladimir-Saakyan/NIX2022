package com.service;

import com.model.Bus;
import com.model.Manufacturer;
import com.repository.BusRepiository;
import com.repository.CrudRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
