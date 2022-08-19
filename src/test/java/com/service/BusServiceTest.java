package com.service;

import com.model.Auto;
import com.model.Bus;
import com.model.Manufacturer;
import com.repository.BusRepiository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusServiceTest {

    private BusService target;
    private BusRepiository busRepiository;
    @BeforeEach
    void setUp() {
        busRepiository  = Mockito.mock(BusRepiository.class);
        target = new BusService(busRepiository);
    }

    @Test
    void createBuses_negative() {

        final List<Bus> actual=target.createBuses(-1); ;
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void createBuses_zero() {

        final List<Bus> actual=target.createBuses(0); ;
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void createBuses() {
        final List<Bus> actual=target.createBuses(3); ;
        Assertions.assertEquals(3, actual.size());
        Mockito.verify(busRepiository, Mockito.times(3)).createCar(Mockito.any());
    }

    @Test
    void printAllBus() {
        List<Bus> buses = List.of(createSimpleBus(), createSimpleBus());
        Mockito.when(busRepiository.getAllCar()).thenReturn(buses);
        target.printAllBus();
    }

    @Test
    void findOneById_null() {
        final Bus expected = createSimpleBus();
        Mockito.when(busRepiository.getByIdCar("")).thenReturn(expected);
        final Bus actual = target.findOneById(null);
        Assertions.assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void update_notFound(){
        final Bus bus = createSimpleBus();
        final boolean actual = busRepiository.updateCar(bus);
        Assertions.assertFalse(actual);
        Mockito.when(busRepiository.updateCar(bus)).thenReturn(actual);
        target.updateBus(bus);
    }

    @Test
    void update_verification(){
        final Bus bus = createSimpleBus();
        bus.setPrice(BigDecimal.ONE);
        final boolean actual = busRepiository.updateCar(bus);
        Assertions.assertTrue(actual);
        Mockito.verify(bus).getId();
    }

    @Test
    void delete_false() {
        final boolean actual = busRepiository.deleteCar("qwe");
        Assertions.assertFalse(actual);
    }

    @Test
    void delete(){
        final Bus bus = createSimpleBus();
        final boolean actual = busRepiository.deleteCar(bus.getId());
        Assertions.assertTrue(actual);
    }

    private Bus createSimpleBus(){
        return new Bus("vivaro", Manufacturer.OPEL, BigDecimal.ZERO, "puss");
    }

}