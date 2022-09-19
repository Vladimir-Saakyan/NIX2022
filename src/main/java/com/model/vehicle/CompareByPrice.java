package com.model.vehicle;

import java.util.Comparator;

public class CompareByPrice implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}

