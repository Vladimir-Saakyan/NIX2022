package com.hw10.repository;

import com.hw10.model.Moto;

import java.util.LinkedList;
import java.util.List;

public class MotoRepository implements CrudRepositoryMoto {

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
        return false;
    }
}
