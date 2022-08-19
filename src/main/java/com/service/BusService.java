package com.service;

import com.model.Bus;
import com.model.Manufacturer;
import com.repository.BusRepiository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusService.class);
    private static final Random RANDOM = new Random();
    private final BusRepiository busRepository;

    public BusService(BusRepiository busRepository){
        this.busRepository = busRepository;
    }

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
            busRepository.createCar(bus);
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
        busRepository.createAllCar(buses);
    }

    public void printAllBus() {
        for (Bus bus : busRepository.getAllCar()) {
            System.out.println(bus);
        }
    }

    public Bus findOneById(String id) {
        if(id == null) {
           return busRepository.getByIdCar("");
        } else  {
           return busRepository.getByIdCar(id);
        }
    }

    public void updateBus(Bus bus) {
        busRepository.updateCar(bus);
         }

    public void deleteBus(String id){
        busRepository.deleteCar(id);

    }
}
