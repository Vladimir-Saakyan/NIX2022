package com.repository;

import com.model.Auto;

import java.util.List;

public interface CrudRepositoryAuto {

    Auto getByIdCar(String id);

    List<Auto> getAllCar();

    boolean createCar(Auto auto);

    boolean createAllCar(List<Auto> auto);

    boolean updateCar(Auto auto);

    boolean deleteCar(String id);
}
