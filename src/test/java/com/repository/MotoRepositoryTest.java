package com.repository;

import com.model.vehicle.Manufacturer;
import com.model.vehicle.Moto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

class MotoRepositoryTest {
    private MotoRepository target;
    private Moto moto;

    @BeforeEach
    void setUp() {
        target = new MotoRepository();
        moto = createSimpleMoto();
        target.createCar(moto);
}

    private Moto createSimpleMoto(){
        return new Moto("street", Manufacturer.BMW, BigDecimal.ZERO, "height");
    }


    @Test
    void getByIdMoto_findOne() {
        final Moto actual = target.getByIdCar(moto.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(moto.getId(),actual.getId());
    }

    @Test
    void getByIdMoto_NotFind() {
        final Moto actual = target.getByIdCar("124");
        Assertions.assertNull(actual);
    }

    @Test
    void getByIdMoto_findOne_ManyMoto() {
        final Moto otherMoto = createSimpleMoto();
        target.createCar(otherMoto);
        final Moto actual = target.getByIdCar(moto.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(moto.getId(),actual.getId());
        Assertions.assertNotEquals(otherMoto.getId(),actual.getId());
    }

    @Test
    void getAllMoto() {
        final List<Moto> actual = target.getAllCar();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    void create_success_notChangePrice(){
        moto.setPrice(BigDecimal.ONE);
        final boolean actual = target.createCar(moto);
        Assertions.assertTrue(actual);
        final Moto actualMoto = target.getByIdCar(moto.getId());
        Assertions.assertEquals(BigDecimal.ONE, actualMoto.getPrice());
    }

    @Test
    void create_success_changePrice(){
        target.createCar(moto);
        final Moto actual = target.getByIdCar(moto.getId());
        Assertions.assertEquals(BigDecimal.valueOf(-1),actual.getPrice());
    }

    @Test
    void createMoto_fail(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.createCar(null));
    }


    @Test
    void saveAllMoto_null() {
        final boolean actual = target.createAllCar(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAllMoto_empty() {
        final boolean actual = target.createAllCar(Collections.emptyList());
        Assertions.assertFalse(actual);
    }

    @Test
    void saveMotoAll(){
        final boolean actual = target.createAllCar(List.of(createSimpleMoto()));
        Assertions.assertTrue(actual);
    }

    @Test
    void updateMoto_notFound() {
        final Moto otherMoto = createSimpleMoto();
        final boolean actual = target.updateCar(otherMoto);
        Assertions.assertFalse(actual);
    }

    @Test
    void updateMoto() {
        moto.setPrice(BigDecimal.TEN);
        final boolean actual = target.updateCar(moto);
        Assertions.assertTrue(actual);
        final Moto actualMoto = target.getByIdCar(moto.getId());
        Assertions.assertEquals(BigDecimal.TEN, actualMoto.getPrice());
    }

    @Test
    void deleteMoto_negative() {
        final boolean actual = target.deleteCar("");
        Assertions.assertFalse(actual);
    }

    @Test
    void deleteMoto() {
        final boolean actual = target.deleteCar(moto.getId());
        Assertions.assertTrue(actual);
    }
}