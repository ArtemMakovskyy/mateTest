package main.java8.stream.classes.p_07.service;


import main.java8.stream.classes.p_07.model.Car;
import main.java8.stream.classes.p_07.model.User;

import java.util.List;
import java.util.Map;

public interface AdService {
    Map<User, List<Car>> getAllMoreThen(int year);
}
