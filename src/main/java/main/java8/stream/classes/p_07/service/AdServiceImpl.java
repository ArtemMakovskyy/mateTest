package main.java8.stream.classes.p_07.service;

import main.java8.stream.classes.p_07.db.Storage;
import main.java8.stream.classes.p_07.model.Advertisment;
import main.java8.stream.classes.p_07.model.Car;
import main.java8.stream.classes.p_07.model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdServiceImpl implements AdService {
    @Override
    public Map<User, List<Car>> getAllMoreThen(int year) {

        Map<User, List<Car>> userListMap =
                Storage.getAdvertisment()
                        .stream()
                        .filter(a -> a.getCar().getYear() >= year)
                        .collect(Collectors.groupingBy
                                (Advertisment::getOwner,
                                        Collectors.mapping(Advertisment::getCar, Collectors.toList()))
                        );
        return userListMap;
    }
}



