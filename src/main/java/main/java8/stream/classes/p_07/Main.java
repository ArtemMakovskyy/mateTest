package main.java8.stream.classes.p_07;

import main.java8.stream.classes.p_07.model.Car;
import main.java8.stream.classes.p_07.model.User;
import main.java8.stream.classes.p_07.service.AdService;
import main.java8.stream.classes.p_07.service.AdServiceImpl;

import java.util.List;
import java.util.Map;

public class Main {
    static AdService adService = new AdServiceImpl();

    public static void main(String[] args) {
        Map<User, List<Car>> allUserListMap = adService.getAllMoreThen(2015);
        ((Map<?, ?>) allUserListMap).forEach((k, v) -> System.out.println(k + " - " + v));
//        for (Map.Entry<User, List<Car>> entry : allUserListMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
    }
}
