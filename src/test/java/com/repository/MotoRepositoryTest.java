package com.repository;

import com.model.Auto;
import com.model.Bus;
import com.model.Manufacturer;
import com.model.Moto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MotoRepositoryTest {
    private MotoRepository target;
    private Moto moto;

    @BeforeEach
    void setUp() {
        target = new MotoRepository();
        moto = createSimpleMoto();
        target.createMoto(moto);
}

    private Moto createSimpleMoto(){
        return new Moto("street", Manufacturer.BMW, BigDecimal.ZERO, "height");
    }


    @Test
    void getByIdMoto_findOne() {
        final Moto actual = target.getByIdMoto(moto.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(moto.getId(),actual.getId());
    }

    @Test
    void getByIdMoto_NotFind() {
        final Moto actual = target.getByIdMoto("124");
        Assertions.assertNull(actual);
    }

    @Test
    void getByIdMoto_findOne_ManyMoto() {
        final Moto otherMoto = createSimpleMoto();
        target.createMoto(otherMoto);
        final Moto actual = target.getByIdMoto(moto.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(moto.getId(),actual.getId());
        Assertions.assertNotEquals(otherMoto.getId(),actual.getId());
    }

    @Test
    void getAllMoto() {
        final List<Moto> actual = target.getAllMoto();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    void create_success_notChangePrice(){
        moto.setPrice(BigDecimal.ONE);
        final boolean actual = target.createMoto(moto);
        Assertions.assertTrue(actual);
        final Moto actualMoto = target.getByIdMoto(moto.getId());
        Assertions.assertEquals(BigDecimal.ONE, actualMoto.getPrice());
    }

    @Test
    void create_success_changePrice(){
        target.createMoto(moto);
        final Moto actual = target.getByIdMoto(moto.getId());
        Assertions.assertEquals(BigDecimal.valueOf(-1),actual.getPrice());
    }

    @Test
    void createMoto_fail(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.createMoto(null));
    }


    @Test
    void saveAllMoto_null() {
        final boolean actual = target.createAllMoto(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAllMoto_empty() {
        final boolean actual = target.createAllMoto(Collections.emptyList());
        Assertions.assertFalse(actual);
    }

    @Test
    void saveMotoAll(){
        final boolean actual = target.createAllMoto(List.of(createSimpleMoto()));
        Assertions.assertTrue(actual);
    }

    @Test
    void updateMoto_notFound() {
        final Moto otherMoto = createSimpleMoto();
        final boolean actual = target.updateMoto(otherMoto);
        Assertions.assertFalse(actual);
    }

    @Test
    void updateMoto() {
        moto.setPrice(BigDecimal.TEN);
        final boolean actual = target.updateMoto(moto);
        Assertions.assertTrue(actual);
        final Moto actualMoto = target.getByIdMoto(moto.getId());
        Assertions.assertEquals(BigDecimal.TEN, actualMoto.getPrice());
    }

    @Test
    void deleteMoto() {
    }
}