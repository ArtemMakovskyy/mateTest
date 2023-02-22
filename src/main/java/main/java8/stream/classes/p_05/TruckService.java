package main.java8.stream.classes.p_05;

import java.util.List;

public interface TruckService {
    List<String>getEngineModel(List<Truck>trucks);
    List<String>getWheelMakers(List<Truck>trucks);
}
