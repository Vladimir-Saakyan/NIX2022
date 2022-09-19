package com.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.UUID;

@Getter
@Setter
public abstract class Vehicle {
    protected final String id;
    protected String model;
    protected int numberRest;
    protected BigDecimal price;
    protected Manufacturer manufacturer;
    protected LocalTime date;

    protected Vehicle(String model, Manufacturer manufacturer, BigDecimal price, int numberRest, LocalTime date) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.numberRest= numberRest;
        this.date = date;
    }
}
