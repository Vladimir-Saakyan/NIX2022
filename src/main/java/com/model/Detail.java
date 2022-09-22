package com.model;

import java.util.Random;

public class Detail {
    final int id;
    final PartView name;
    Random random = new Random();

    public Detail(int id, PartView name) {
        this.id = random.nextInt(10);
        this.name = name;
    }
}
