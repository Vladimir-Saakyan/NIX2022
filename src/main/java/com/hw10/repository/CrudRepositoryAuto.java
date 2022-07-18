package com.hw10.repository;

import com.hw10.model.Auto;
import com.hw10.model.Bus;
import com.hw10.model.Moto;

import java.util.List;

public interface CrudRepositoryAuto {

    Auto getByIdCar(String id);

    List<Auto> getAllCar();

    boolean createCar(Auto auto);

    boolean createCar(List<Auto> auto);

    boolean updateCar(Auto auto);

    boolean deleteCar(String id);
}
