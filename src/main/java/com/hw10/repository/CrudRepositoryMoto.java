package com.hw10.repository;

import com.hw10.model.Moto;

import java.util.List;

public interface CrudRepositoryMoto {
    Moto getByIdMoto(String id);

    List<Moto> getAllMoto();

    boolean createMoto(Moto moto);

    boolean createMoto(List<Moto> moto);

    boolean updateMoto(Moto moto);

    boolean deleteMoto(String id);
}
