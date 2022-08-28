package com.service;

import com.model.vehicle.Vehicle;
import com.repository.CrudRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Service<T extends Vehicle> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
    protected static final Random RANDOM = new Random();
    protected final CrudRepo<T> repository;

    protected Service(CrudRepo<T> repository) {
        this.repository = repository;
    }

    protected abstract T create();
    public List<T> createAndSaveAutos(int count) {
        List<T> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            final T vehicle = create();
            result.add(vehicle);
            repository.createCar(vehicle);
            LOGGER.debug("Created vehicle {}", vehicle.getId());
        }
        return result;
    }
    public void saveAutos(List<T> vehicle) {
        repository.createAllCar(vehicle);
    }

    public void printAll() {
        for (T vehicle : repository.getAllCar()) {
            System.out.println(vehicle);
        }
    }


    public T update(T vehicle) {
        repository.updateCar(vehicle);
        return vehicle;
    }

    public void delete(String id) {
        repository.deleteCar(id);
        System.out.println(id);
    }
}
