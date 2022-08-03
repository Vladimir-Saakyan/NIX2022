package com.service;

import com.model.Auto;
import com.model.Manufacturer;
import com.repository.AutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

class AutoServiceTest {
    private AutoService target;
    private AutoRepository autoRepository;

    @BeforeEach
    void setUp() {
        autoRepository = Mockito.mock(AutoRepository.class) ;
        target = new AutoService(autoRepository);
    }

    @Test
    void createAutos_negativeCount() {
       final List<Auto> actual = target.createAndSaveAutos(-1);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void createAutos_zeroCount() {
        final List<Auto> actual = target.createAndSaveAutos(0);
        Assertions.assertEquals(0, actual.size());
    }
    @Test
    void createAutos() {
        final List<Auto> actual = target.createAndSaveAutos(5);
        Assertions.assertEquals(5, actual.size());
        Mockito.verify(autoRepository, Mockito.times(5)).createCar(Mockito.any());
    }

    @Test
    void argMatch() {
        final Auto auto = createSimpleAuto();
        final boolean actual = autoRepository.updateCar(auto);
        Assertions.assertFalse(actual);
        Mockito.verify(autoRepository,Mockito.times(1)).updateCar(Mockito.any());
    }

    @Test
    void printAll() {
        List<Auto> autos = List.of(createSimpleAuto(),createSimpleAuto());
        Mockito.when(autoRepository.getAllCar()).thenReturn(autos);
        target.printAll();
    }

    @Test
    void findOneById_null(){
        final Auto auto = createSimpleAuto();
        Mockito.when(autoRepository.getByIdCar("")).thenReturn(auto);
        target.findOneById(null);
    }

    @Test
    void update_notFound(){
        final Auto auto = createSimpleAuto();
        final boolean actual = autoRepository.updateCar(auto);
        Assertions.assertFalse(actual);
        Mockito.when(autoRepository.updateCar(auto)).thenReturn(actual);
        target.update(auto);
    }

    @Test
    void update_verification(){
        final Auto auto = createSimpleAuto();
        auto.setPrice(BigDecimal.ONE);
        final boolean actual = autoRepository.updateCar(auto);
        Assertions.assertTrue(actual);
        Mockito.verify(auto).getId();
    }

    @Test
    void delete_false() {
        final boolean actual = autoRepository.deleteCar("qwe");
        Assertions.assertFalse(actual);
    }

    @Test
    void delete(){
        final Auto auto = createSimpleAuto();
        final boolean actual = autoRepository.deleteCar(auto.getId());
        Assertions.assertTrue(actual);
    }

    private Auto createSimpleAuto(){
        return new Auto("7", Manufacturer.BMW, BigDecimal.ZERO,"sedan");
    }
}