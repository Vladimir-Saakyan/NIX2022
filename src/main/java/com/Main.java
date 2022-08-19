package com;

import com.model.Auto;
import com.model.Manufacturer;
import com.model.Moto;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import com.service.AutoService;
import com.model.Bus;
import com.service.BusService;
import com.service.MotoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final AutoService AUTO_SERVICE = new AutoService(new AutoRepository());
    private static final BusService BUS_SERVICE = new BusService(new BusRepiository());
    private static final MotoService MOTO_SERVICE = new MotoService(new MotoRepository());
    public static void main(String[] args) {

        System.out.println("                                                                 ===AUTO===");

        final List<Auto> autos = AUTO_SERVICE.createAndSaveAutos(5);
        Auto auto = autos.get(0);
        AUTO_SERVICE.saveAutos(autos);
        AUTO_SERVICE.printAll();
        AUTO_SERVICE.update(auto);
        AUTO_SERVICE.delete(auto.getId());
        System.out.println("- - - - - - -  after remove auto  - - - - - - - - ");
        AUTO_SERVICE.printAll();

        System.out.println("                                                                 ===BUS===");

        final List<Bus> buses = BUS_SERVICE.createBuses(2);
        Bus bus = buses.get(0);
        BUS_SERVICE.saveBuses(buses);
        BUS_SERVICE.printAllBus();
        BUS_SERVICE.updateBus(bus);
        BUS_SERVICE.deleteBus(bus.getId());
        System.out.println("- - - - - - -  after remove bus  - - - - - - - - ");
        BUS_SERVICE.printAllBus();

        System.out.println("                                                                 ===MOTO===");

        final List<Moto> motos = MOTO_SERVICE.createMoto(5);
        Moto moto = motos.get(0);
        MOTO_SERVICE.saveMoto(motos);
        MOTO_SERVICE.printAllMotos();
        MOTO_SERVICE.updateMoto(moto);
        MOTO_SERVICE.deleteMoto(moto.getId());
        System.out.println("- - - - - - -  after remove moto  - - - - - - - - ");
        MOTO_SERVICE.printAllMotos();

        System.out.println("- - - - - - -  hw12  - - - - - - - - ");
        AUTO_SERVICE.findOneById(auto.getId());
        AUTO_SERVICE.findPriceForId(auto.getId());
        AUTO_SERVICE.findAuto(auto.getId());
        AUTO_SERVICE.findManufactureById(auto.getId());
//        AUTO_SERVICE.findMethod(auto.getId());
        AUTO_SERVICE.findAllPrice(auto.getId());

        System.out.println("- - - - - - -  hw13  - - - - - - - - ");

        System.out.println("- - - - - - -  hw21  - - - - - - - - ");

    }
}
