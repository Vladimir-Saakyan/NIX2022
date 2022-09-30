package com.service;

import com.model.vehicle.Auto;
import com.model.vehicle.Manufacturer;
import com.repository.AutoRepository;
import com.repository.CrudRepo;
import com.repository.DetailRepo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoService extends Service<Auto> {
    private static AutoService instanse;
    private DetailRepo detailRepo = new DetailRepo();

    public AutoService(CrudRepo<Auto> repository) {
       super(repository);
    }

    public static AutoService getInstanse() {
        if(instanse == null){
            instanse = new AutoService(AutoRepository.getInstance());
        }
        return instanse;
    }

    public Auto create(){
        return  new Auto(
                "Model-" + RANDOM.nextInt(1000),
                getRandomManufacturer(),
                BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                "Model-" + RANDOM.nextInt(1000),

                RANDOM.nextInt(10),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),detailRepo.getDetails()

        );
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    private List<String> getDefaultList(){
        List<String> list = new ArrayList<String>();
        list.add(1, "engine");
        return list;
    }
}
