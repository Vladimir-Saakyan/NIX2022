package com.hw10.service;

import com.hw10.model.Auto;
import com.hw10.model.Bus;
import com.hw10.model.Manufacturer;
import com.hw10.repository.AutoRepository;
import com.hw10.repository.BusRepiository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AutoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);
    private static final Random RANDOM = new Random();
    private static final AutoRepository AUTO_REPOSITORY = new AutoRepository();

    public List<Auto> createAutos(int count) {
        List<Auto> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            final Auto auto = new Auto(
                    "Model-" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model-" + RANDOM.nextInt(1000)
            );
            result.add(auto);
            LOGGER.debug("Created auto {}", auto.getId());
        }
        return result;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void saveAutos(List<Auto> autos) {
        AUTO_REPOSITORY.createCar(autos);
    }

    public void printAll() {
        for (Auto auto : AUTO_REPOSITORY.getAllCar()) {
            System.out.println(auto);
        }
    }

    public void update(Auto auto) {
        AUTO_REPOSITORY.updateCar(auto);
    }

    public void delete(String id){
        System.out.println(id);
    }

}
