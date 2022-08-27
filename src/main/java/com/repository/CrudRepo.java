package com.repository;

import com.model.Auto;
import com.model.Bus;
import com.model.Vehicle;

import java.util.List;

public interface CrudRepo<T extends Vehicle> {
    T getByIdCar(String id);

    List<T> getAllCar();

    boolean createCar(T auto);

    boolean createAllCar(List<T> auto);

    boolean updateCar(T auto);

    boolean deleteCar(String id);
}
