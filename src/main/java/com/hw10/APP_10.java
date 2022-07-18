package com.hw10;

import com.hw10.model.Auto;
import com.hw10.model.Moto;
import com.hw10.model.Vehicle;
import com.hw10.repository.AutoRepository;
import com.hw10.service.AutoService;
import com.hw10.model.Bus;
import com.hw10.service.BusService;
import com.hw10.service.MotoService;

import java.util.List;


public class APP_10 {
    private static final AutoService AUTO_SERVICE = new AutoService();
    private static final BusService BUS_SERVICE = new BusService();
    private static final MotoService MOTO_SERVICE = new MotoService();

    public static void app() {

        System.out.println("                                                                 ===AUTO===");

        final List<Auto> autos = AUTO_SERVICE.createAutos(10);
        AUTO_SERVICE.saveAutos(autos);
        AUTO_SERVICE.printAll();
//        AUTO_SERVICE.update(auto);
//        AUTO_SERVICE.delete(id);

        System.out.println("                                                                 ===BUS===");

        final List<Bus> buses = BUS_SERVICE.createBuses(2);
        BUS_SERVICE.saveBuses(buses);
        BUS_SERVICE.printAllBus();

        System.out.println("                                                                 ===MOTO===");

        final List<Moto> motos = MOTO_SERVICE.createMoto(5);
        MOTO_SERVICE.saveMoto(motos);
        MOTO_SERVICE.printAllMotos();
    }
}
