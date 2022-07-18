package com.hw10.repository;

import com.hw10.model.Bus;

import java.util.LinkedList;
import java.util.List;

public class BusRepiository implements CrudRepositoryBus {

    private final List<Bus> buses;

    public BusRepiository() {
        buses = new LinkedList<>();
    }

    @Override
    public Bus getByIdBus(String id) {
        for(Bus bus: buses){
            if(bus.getId().equals(id)){
                return bus;
            }
        }
        return null;
    }

    @Override
    public List<Bus> getAllBus() {
        return buses;
    }

    @Override
    public boolean createBus(Bus bus) {
        buses.add(bus);
        return true;
    }

    @Override
    public boolean createBus(List<Bus> bus) {
        return buses.addAll(bus);
    }

    @Override
    public boolean updateBus(Bus bus) {
        return false;
    }

    @Override
    public boolean deleteBus(String id) {
        return false;
    }
}
