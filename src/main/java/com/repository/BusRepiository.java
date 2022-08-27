package com.repository;

import com.model.Bus;
import com.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BusRepiository implements CrudRepositoryBus {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);

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
        if(bus == null){
            throw  new IllegalArgumentException("Invalid bus");
        }
        if(bus.getPrice().equals(BigDecimal.ZERO)){
            bus.setPrice(BigDecimal.valueOf(-1));
        }
        buses.add(bus);
        return true;
    }

    @Override
    public boolean createAllBus(List<Bus> bus) {
        if(bus == null){
            return false;
        }
        return buses.addAll(bus);
    }

    @Override
    public boolean updateBus(Bus bus) {
        final Bus founded = getByIdBus(bus.getId());
        if (founded != null) {
            BusCopy.copy(bus, founded);

            System.out.println("Updated auto: \n"+ bus);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBus(String id) {
        final Iterator<Bus> iterator = buses.iterator();
        while (iterator.hasNext()) {
            final Bus bus = iterator.next();
            if (bus.getId().equals(id)) {
                iterator.remove();
                System.out.println("\nRemoved Bus: \n"+ bus);
                LOGGER.debug("\n* Log remove auto : " + bus.getId()+"*");
                return true;
            }
        }
        return false;
    }
    private static class BusCopy {
        static void copy(final Bus from, final Bus to) {

            to.setModel(from.getModel());
            to.setBodytype(from.getBodytype());
            to.setPrice(from.getPrice());
        }
    }
}
