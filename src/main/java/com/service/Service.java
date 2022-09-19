package com.service;

import com.model.vehicle.Auto;
import com.model.vehicle.Vehicle;
import com.repository.CrudRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
            System.out.println(vehicle.getClass());
        }
        return result;
    }
    public void save(List<Auto> vehicle) {
        repository.createAllCar((List<T>) vehicle);
    }

    public void printAll() {
        for (T vehicle : repository.getAllCar()) {
            System.out.println(vehicle);
        }
    }


    public T update(T vehicle) {
        updateInMenu();
        repository.updateCar(vehicle);
        return vehicle;
    }

    public T updateInMenu(){
        System.out.println("change car for update: ");
        for (T vehicle : repository.getAllCar()) {
            System.out.println(vehicle);
        }
        Scanner sc = new Scanner(System.in);
        final String id = sc.nextLine();
        T vehicle = repository.getByIdCar(id);
        repository.updateCar(vehicle);
        return vehicle;
    }

    public void delete() {
        System.out.println("change car for delete: ");
        for (T vehicle : repository.getAllCar()) {
            System.out.println(vehicle);
        }
        Scanner sc = new Scanner(System.in);
        final String id = sc.nextLine();
        T vehicle = repository.getByIdCar(id);
        repository.deleteCar(id);
        System.out.println(id);
    }
}
