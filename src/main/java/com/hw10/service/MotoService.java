package com.hw10.service;

import com.hw10.model.Bus;
import com.hw10.model.Manufacturer;
import com.hw10.model.Moto;
import com.hw10.repository.MotoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MotoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusService.class);

    final static Random RANDOM = new Random();

    final static MotoRepository MOTO_REPOSITORY = new MotoRepository();

    public List<Moto> createMoto(int count){
        List<Moto> result = new LinkedList<>();
       for(int i = 0; i < count; i++){
           final Moto moto = new Moto(
                   "Model Moto -" + RANDOM.nextInt(1000),
                   getRandomManufacturer(),
                   BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                   "Model MOto-" + RANDOM.nextInt(1000)
           );
           result.add(moto);
           LOGGER.debug("Created moto {}", moto.getId());

       } return result;


    }
    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void saveMoto(List<Moto> motos){
        MOTO_REPOSITORY.createMoto(motos);
    }

    public void printAllMotos(){
        for (Moto moto : MOTO_REPOSITORY.getAllMoto()){
            System.out.println(moto);
        }
    }

    public void updateMoto(Moto moto) {
        MOTO_REPOSITORY.updateMoto(moto);
    }

    public void deleteMoto(String id){
        MOTO_REPOSITORY.deleteMoto(id);    }

}
