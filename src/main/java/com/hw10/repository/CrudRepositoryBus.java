package com.hw10.repository;

import com.hw10.model.Bus;

import java.util.List;

public interface CrudRepositoryBus {
    Bus getByIdBus(String id);

    List<Bus> getAllBus();

    boolean createBus(Bus bus);

    boolean createBus(List<Bus> bus);

    boolean updateBus(Bus bus);

    boolean deleteBus(String id);
}
