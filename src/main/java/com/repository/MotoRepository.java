package com.repository;

import com.model.Bus;
import com.model.Moto;
import com.service.AutoService;
import com.service.MotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MotoRepository implements CrudRepo<Moto> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MotoService.class);
    private final List<Moto> motos;

    public MotoRepository(){
        motos = new LinkedList<>();
    }


    @Override
    public Moto getByIdCar(String id) {
        for (Moto moto : motos){
            if (moto.getId().equals(id)){
                return moto;
            }
        }
        return null;
    }

    @Override
    public List<Moto> getAllCar() {

        return motos;
    }

    @Override
    public boolean createCar(Moto moto) {
        if(moto == null){
            throw  new IllegalArgumentException("Invalid moto");
        }
        if(moto.getPrice().equals(BigDecimal.ZERO)){
            moto.setPrice(BigDecimal.valueOf(-1));
        }
        return motos.add(moto);
    }

    @Override
    public boolean createAllCar(List<Moto> moto) {
        if(moto == null){
            return false;
        }
        return  motos.addAll(moto);
    }

    @Override
    public boolean updateCar(Moto moto) {
        final Moto founded = getByIdCar(moto.getId());
        if (founded != null) {
            MotoRepository.MotoCopy.copy(moto,founded);

            System.out.println("Updated auto: \n"+ moto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCar(String id) {
        final Iterator<Moto> iterator = motos.iterator();
        while (iterator.hasNext()) {
            final Moto moto = iterator.next();
            if (moto.getId().equals(id)) {
                iterator.remove();
                System.out.println("\n*Removed Moto: \n"+ moto+"*");
                LOGGER.debug("\n Log remove moto : " + moto.getId());
                return true;
            }
        }
        return false;
    }

    private static class MotoCopy {
        static void copy(final Moto from, final Moto to) {
            to.setModel(from.getModel());
            to.setBodyType(from.getBodyType());
            to.setPrice(from.getPrice());
        }
    }
}
