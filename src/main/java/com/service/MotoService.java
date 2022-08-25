package com.service;

import com.model.Manufacturer;
import com.model.Moto;
import com.model.Vehicle;
import com.repository.CrudRepo;
import com.repository.MotoRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MotoService extends Service {


    public MotoService(CrudRepo<Moto> repository) {
       super(repository);
    }

    @Override
    protected Vehicle create() {
        return new Moto(
                "Model Moto -" + RANDOM.nextInt(1000),
                getRandomManufacturer(),
                BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                "Model MOto-" + RANDOM.nextInt(1000)
        );
    }
    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }
}
