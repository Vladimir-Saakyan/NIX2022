package com.service;

import com.model.Manufacturer;
import com.model.Moto;
import com.repository.MotoRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MotoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusService.class);

    private final static Random RANDOM = new Random();
    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }
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
           motoRepository.createMoto(moto);
           LOGGER.debug("Created moto {}", moto.getId());

       } return result;


    }
    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void saveMoto(List<Moto> motos){
        motoRepository.createAllMoto(motos);
    }

    public void printAllMotos(){
        for (Moto moto : motoRepository.getAllMoto()){
            System.out.println(moto);
        }
    }

    public Moto findOneById(String id){
        if(id == null){
           return motoRepository.getByIdMoto("");
        } else {
           return motoRepository.getByIdMoto(id);
        }
    }

    public void updateMoto(Moto moto) {
        motoRepository.updateMoto(moto);
    }

    public void deleteMoto(String id){
        motoRepository.deleteMoto(id);    }

}
