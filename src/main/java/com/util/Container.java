package com.util;

import com.model.Auto;
import com.model.Bus;
import com.model.Moto;
import com.model.Vehicle;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import lombok.Getter;
import lombok.Setter;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Container {
    private final AutoService AUTO_SERVICE =
            new AutoService(new AutoRepository());
    private final BusService BUS_SERVICE =
            new BusService(new BusRepiository());
    private final MotoService MOTO_SERVICE =
            new MotoService(new MotoRepository());

    public Container() {

    }

    private List<? extends Vehicle> creareAndSave() {
        final List<Vehicle> vehicleList = new LinkedList<>();
        final List<Auto> autos = AUTO_SERVICE.createAndSaveAutos(5);
        final List<Bus> buses = BUS_SERVICE.createAndSaveAutos(2);
        final List<Moto> motos = MOTO_SERVICE.createAndSaveAutos(5);
        for (Vehicle vehicle : autos) {
            vehicleList.add(vehicle);
            System.out.println(vehicle);
        }
        for (Vehicle vehicle : buses) {
            vehicleList.add(vehicle);
            System.out.println(vehicle);
        }
        for (Vehicle vehicle : motos) {
            vehicleList.add(vehicle);
            System.out.println(vehicle);
        }
        System.out.println("------");
        System.out.println(vehicleList.size());
        return vehicleList;
    }

    public void prinall() {
        final List<? extends Vehicle> vehicleList = creareAndSave();
        for (Vehicle el : vehicleList) {
            System.out.println(el);
        }
    }

    public BigDecimal discount() {
        BigDecimal count = BigDecimal.valueOf(0.1 + Math.random() + 0.3);
        return count;
    }

    public void dPrice(){
        discount();
        Number pr = null;
        final List<? extends Vehicle> cars = creareAndSave();
        for (Vehicle el : cars){
            pr = el.getPrice().multiply(discount());
            System.out.println("for car - " + el.getId() +" discount price - " + pr);
        }
    }
}
