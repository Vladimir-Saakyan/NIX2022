package com.repository;

import com.model.Auto;
import com.model.Bus;
import com.model.Manufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

class BusRepiositoryTest {
    private BusRepiository target;
    private Bus bus;

    @BeforeEach
    void setUp() {
        target = new BusRepiository();
        bus = createSimpleBus();
        target.createBus(bus);
    }

    private Bus createSimpleBus(){
        return new Bus("vivaro", Manufacturer.OPEL, BigDecimal.ZERO, "puss");
    }

    @Test
    void getByIdBus_findOne() {
        final Bus actual = target.getByIdBus(bus.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(bus.getId(),actual.getId());
    }

    @Test
    void getByIdBus_NotFind() {
        final Bus actual = target.getByIdBus("14");
        Assertions.assertNull(actual);
    }

    @Test
    void getByIdBus_findOne_manyBus() {
        final Bus otherBus = createSimpleBus();
        target.createBus(otherBus);
        final Bus actual = target.getByIdBus(bus.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(bus.getId(),actual.getId());
        Assertions.assertNotEquals(otherBus.getId(), actual.getId());
    }

    @Test
    void getAllBus() {
        final List<Bus> actual = target.getAllBus();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1,actual.size());
    }

    @Test
    void create_success_changePrice(){
        target.createBus(bus);
        final Bus actual = target.getByIdBus(bus.getId());
        Assertions.assertEquals(BigDecimal.valueOf(-1),actual.getPrice());
    }


    @Test
    void createBus_fail(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->target.createBus(null));
    }


    @Test
    void saveAllBus_null () {
        final boolean actual = target.createAllBus(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAllBus_emptyList(){
        final boolean actual = target.createAllBus(Collections.emptyList());
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAllCar(){
        final boolean actual = target.createAllBus(List.of(createSimpleBus()));
        Assertions.assertTrue(actual);
    }

    @Test
    void updateBus_notFound() {
        final Bus otherBus = createSimpleBus();
        final boolean actual = target.updateBus(otherBus);
        Assertions.assertFalse(actual);
    }

    @Test
    void updateBus() {
        bus.setPrice(BigDecimal.TEN);
        final boolean actual = target.updateBus(bus);
        Assertions.assertTrue(actual);
        final Bus actualBus = target.getByIdBus(bus.getId());
        Assertions.assertEquals(BigDecimal.TEN, actualBus.getPrice());
    }

    @Test
    void deleteBus_negative() {
        final boolean actual = target.deleteBus("");
        Assertions.assertFalse(actual);
    }

    @Test
    void deleteBus() {
        final boolean actual = target.deleteBus(bus.getId());
        Assertions.assertTrue(actual);
    }
}