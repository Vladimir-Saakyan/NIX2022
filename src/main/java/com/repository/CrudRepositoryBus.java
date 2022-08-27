package com.repository;

import com.model.Bus;

import java.util.List;

public interface CrudRepositoryBus {
    Bus getByIdBus(String id);

    List<Bus> getAllBus();

    boolean createBus(Bus bus);

    boolean createAllBus(List<Bus> bus);

    boolean updateBus(Bus bus);

    boolean deleteBus(String id);
}
