package com.service;

import com.model.vehicle.Manufacturer;
import com.model.vehicle.Moto;
import com.model.vehicle.Vehicle;
import com.repository.CrudRepo;
import com.repository.MotoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MotoService extends Service {
    private static MotoService instance;


    private MotoService(CrudRepo<Moto> repository) {
       super(repository);
    }

    public static MotoService getInstance() {
        if (instance == null) {
            instance = new MotoService(MotoRepository.getInstance());
        }
        return instance;
    }
    @Override
    protected Vehicle create() {
        return new Moto(
                "Model Moto -" + RANDOM.nextInt(1000),
                getRandomManufacturer(),
                BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                "Model MOto-" + RANDOM.nextInt(1000),
                RANDOM.nextInt(10), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }
    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }
}
