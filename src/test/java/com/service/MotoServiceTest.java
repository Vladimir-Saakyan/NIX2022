package com.service;

import com.model.Manufacturer;
import com.model.Moto;
import com.repository.MotoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

class MotoServiceTest {
    private MotoService target;
    private MotoRepository motoRepository;

    @BeforeEach
    void setUp() {
        motoRepository = Mockito.mock(MotoRepository.class);
        target = new MotoService(motoRepository);
    }

    @Test
    void createMoto_negativeCount() {
        final List<Moto> actual = target.createMoto(-1);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void createMoto_zeroCount() {
        final List<Moto> actual = target.createMoto(0);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void createMoto() {
        final List<Moto> actual = target.createMoto(2);
        Assertions.assertEquals(2, actual.size());
        Mockito.verify(motoRepository, Mockito.times(2)).createMoto(Mockito.any());
    }

    @Test
    void saveMoto() {
    }

    @Test
    void printAllMotos() {
        List<Moto> motos = List.of(createSimpleMoto(), createSimpleMoto());
        Mockito.when(motoRepository.getAllMoto()).thenReturn(motos);
        target.printAllMotos();
    }

    @Test
    void findOneById_null() {
        final Moto moto = createSimpleMoto();
        Mockito.when(motoRepository.getByIdMoto("")).thenReturn(moto);
        target.findOneById(null);
    }

    @Test
    void updateMoto() {
    }

    @Test
    void deleteMoto() {
    }

    private Moto createSimpleMoto(){
        return new Moto("street", Manufacturer.BMW, BigDecimal.ZERO, "height");
    }
}