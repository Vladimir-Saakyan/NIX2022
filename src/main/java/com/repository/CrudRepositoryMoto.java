package com.repository;

import com.model.Moto;

import java.util.List;

public interface CrudRepositoryMoto {
    Moto getByIdMoto(String id);

    List<Moto> getAllMoto();

    boolean createMoto(Moto moto);

    boolean createAllMoto(List<Moto> moto);

    boolean updateMoto(Moto moto);

    boolean deleteMoto(String id);
}
