package com.hw11;

import com.hw11.model.Auto;
import com.hw11.repository.AutoRepository;
import com.hw11.service.AutoService;

import java.util.List;

public class App_11 {
    private static final AutoService AUTO_SERVICE = new AutoService(new AutoRepository());

    public static void app() {
        final List<Auto> autos = AUTO_SERVICE.createAndSaveAutos(10);
        AUTO_SERVICE.saveAutos(autos);
        AUTO_SERVICE.printAll();
    }
}