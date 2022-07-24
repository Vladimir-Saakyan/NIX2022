package com.hw10.repository;

import com.hw10.model.Bus;
import com.hw10.model.Moto;
import com.hw10.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MotoRepository implements CrudRepositoryMoto {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);

    private final List<Moto> motos;

    public MotoRepository(){
        motos = new LinkedList<>();
    }


    @Override
    public Moto getByIdMoto(String id) {
        for (Moto moto : motos){
            if (moto.getId().equals(id)){
                return moto;
            }
        }
        return null;
    }

    @Override
    public List<Moto> getAllMoto() {

        return motos;
    }

    @Override
    public boolean createMoto(Moto moto) {

        return motos.add(moto);
    }

    @Override
    public boolean createMoto(List<Moto> moto) {
        return  motos.addAll(moto);
    }

    @Override
    public boolean updateMoto(Moto moto) {
        return false;
    }

    @Override
    public boolean deleteMoto(String id) {
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
}
