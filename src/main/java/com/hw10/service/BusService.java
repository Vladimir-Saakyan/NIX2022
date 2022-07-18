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

public class BusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusService.class);
    private static final Random RANDOM = new Random();
    private static final BusRepiository BUS_REPIOSITORY = new BusRepiository();

    public List<Bus> createBuses(int count) {
        List<Bus> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            final Bus bus = new Bus(
                    "Model Bus -" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model Bus-" + RANDOM.nextInt(1000)
            );
            result.add(bus);
            LOGGER.debug("Created bus {}", bus.getId());
        }
        return result;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void saveBuses(List<Bus> buses) {
        BUS_REPIOSITORY.createBus(buses);
    }

    public void printAllBus() {
        for (Bus bus : BUS_REPIOSITORY.getAllBus()) {
            System.out.println(bus);
        }
    }

    public void updateBus(Bus bus) {
        BUS_REPIOSITORY.updateBus(bus);
    }

    public void deleteBus(String id){
        System.out.println(id);
    }
}
