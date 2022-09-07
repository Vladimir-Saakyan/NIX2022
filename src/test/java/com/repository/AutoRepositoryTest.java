package com.repository;

import com.model.vehicle.Auto;
import com.model.vehicle.Manufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


class AutoRepositoryTest {
    private AutoRepository target;
    private Auto auto;

    @BeforeEach
    void setUp() {
        target = new AutoRepository();
        auto = createSimpleAuto();
        target.createCar(auto);
    }

    private Auto createSimpleAuto(){
        return new Auto("7", Manufacturer.BMW, BigDecimal.ZERO,"sedan");
    }

    @Test
    void getByIdCar_findOne() {
        final Auto actual = target.getByIdCar(auto.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(auto.getId(),actual.getId());
    }

    @Test
    void getByIdCar_NotFind() {
        final Auto actual = target.getByIdCar("123");
        Assertions.assertNull(actual);
    }

    @Test
    void getByIdCar_FindOne_manyAutos() {
        final Auto otherAuto = createSimpleAuto();
        target.createCar(otherAuto);
        target.createCar(createSimpleAuto());
        final Auto actual = target.getByIdCar(auto.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(auto.getId(),actual.getId());
        Assertions.assertNotEquals(otherAuto.getId(),actual.getId());
    }

    @Test
    void getAllCar() {
        final List<Auto> actual = target.getAllCar();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    void create_success_notChangePrice(){
        auto.setPrice(BigDecimal.ONE);
        final boolean actual = target.createCar(auto);
        Assertions.assertTrue(actual);
        final Auto actualAuto = target.getByIdCar(auto.getId());
        Assertions.assertEquals(BigDecimal.ONE, actualAuto.getPrice());
    }

    @Test
    void create_success_changePrice(){
        target.createCar(auto);
        final Auto actual = target.getByIdCar(auto.getId());
        Assertions.assertEquals(BigDecimal.valueOf(-1),actual.getPrice());
    }

    @Test
    void createAuto_fail(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->target.createCar(null));
    }

    @Test
    void saveAllCar_null() {
        final boolean actual = target.createAllCar(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAllCar_emptyList(){
        final boolean actual = target.createAllCar(Collections.emptyList());
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAllCar(){
        final boolean actual = target.createAllCar(List.of(createSimpleAuto()));
        Assertions.assertTrue(actual);
    }

    @Test
    void updateCar_notFound() {
        final Auto otherAuto = createSimpleAuto();
        final boolean actual = target.updateCar(otherAuto);
        Assertions.assertFalse(actual);
    }

    @Test
    void updateCar() {
        auto.setPrice(BigDecimal.TEN);
        final boolean actual = target.updateCar(auto);
        Assertions.assertTrue(actual);
        final Auto actualAuto = target.getByIdCar(auto.getId());
        Assertions.assertEquals(BigDecimal.TEN, actualAuto.getPrice());
    }

    @Test
    void deleteCar_negative() {
        final boolean actual = target.deleteCar("1");
        Assertions.assertFalse(actual);
    }

    @Test
    void deleteCar(){
        final   boolean actual = target.deleteCar(auto.getId());
        Assertions.assertTrue(actual);
    }
}