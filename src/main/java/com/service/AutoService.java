package com.service;

import com.model.vehicle.Auto;
import com.model.vehicle.Manufacturer;
import com.repository.AutoRepository;
import com.repository.CrudRepo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AutoService extends Service<Auto> {
    private static AutoService instanse;

    private AutoService(CrudRepo<Auto> repository) {
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
                RANDOM.nextInt(10), LocalTime.now()
        );
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }


//    public Optional<Auto> findOneById(String id) {
//        Optional.of(autoRepository.getByIdCar(id)).ifPresent(auto -> auto.getId());
//        System.out.println(id);
//        return Optional.empty();
//    }
//
//    public Optional<Auto> findAllPrice(String id){
//        Auto result = Optional.of(autoRepository.getPrice(id)).map(auto->autoRepository.getByIdCar(id))
//                .orElseThrow(()->new IllegalArgumentException("cannot find"));
//        return Optional.ofNullable(result);
//    }
//
//
////    public void filterPrice(String id){
////        List<Auto> result = Optional.of(autoRepository.getPrice(id))
////                .filter(values -> autoRepository.getPrice(id) > 0)
////                .orElseThrow(new IllegalArgumentException("invalid price"));
////    }
//    public Optional<Auto> findAutos(String id){
//        Optional.of(autoRepository.getByIdCar(id))
//                .ifPresentOrElse(auto -> auto.getId()
//                ,(() -> System.out.println("auto is empty")));
//        return Optional.empty();
//    }
//
//    public Optional<Auto> findPriceForId(String id) {
//        Optional.of(autoRepository.getPrice(id)).orElse(BigDecimal.ONE);
//        System.out.println(autoRepository.getPrice(id));
//        return Optional.ofNullable(null);
//    }
//
//    public Optional<Auto> findAuto(String id) {
//        Optional.of(autoRepository.getByIdCar(id)).orElseGet(() ->
//                new Auto("qwerty",
//                        KIA,
//                        BigDecimal.ZERO,
//                        "qwerty"));
//        System.out.println(autoRepository.getByIdCar(id));
//        return Optional.empty();
//    }
//
//    public void findManufactureById(String id) {
//        try {
//            Optional.of(autoRepository.getManufactureById(id)).
//                    orElseThrow(() -> new IllegalArgumentException("Cannot find auto" + id));
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//    }
////    public void findMethod(String id) {
////        final Optional<Auto> met = autoRepository.getManufactureById(id).or(()->Optional.of(defaultAuto()));
////        met.ifPresent(auto -> System.out.println(auto.getModel()));
////    }
//
//
//    private Auto defaultAuto(){
//        return new Auto(
//                "qwerty",
//                getRandomManufacturer(),
//                BigDecimal.ZERO,
//                "model - " + RANDOM.nextLong(100)) ;
//    }
}
