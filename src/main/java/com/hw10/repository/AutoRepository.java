package com.hw10.repository;

import com.hw10.model.Auto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AutoRepository implements CrudRepositoryAuto {
    private final List<Auto> autos;

    public AutoRepository() {
        autos = new LinkedList<>();
    }

    @Override
    public Auto getByIdCar(String id) {
        for (Auto auto : autos) {
            if (auto.getId().equals(id)) {
                return auto;
            }
        }
        return null;
    }

    @Override
    public List<Auto> getAllCar() {
        return autos;
    }

    @Override
    public boolean createCar(Auto auto) {
        autos.add(auto);
        return true;
    }

    @Override
    public boolean createCar(List<Auto> auto) {
        return autos.addAll(auto);
    }

    @Override
    public boolean updateCar(Auto auto) {
        final Auto founded = getByIdCar(auto.getId());
        if (founded != null) {
            AutoCopy.copy(auto, founded);

            System.out.println("Updated auto: \n"+ auto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCar(String id ) {
        final Iterator<Auto> iterator = autos.iterator();
        while (iterator.hasNext()) {
            final Auto auto = iterator.next();
            if (auto.getId().equals(id)) {
                iterator.remove();
                System.out.println("Removed auto: \n"+ auto);
                return true;
            }
        }
        return false;
    }

    private static class AutoCopy {
        static void copy(final Auto from, final Auto to) {
            to.setManufacturer(from.getManufacturer());
            to.setModel(from.getModel());
            to.setBodyType(from.getBodyType());
            to.setPrice(from.getPrice());
        }
    }
}
