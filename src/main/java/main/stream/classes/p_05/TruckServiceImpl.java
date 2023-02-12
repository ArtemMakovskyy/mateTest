package main.stream.classes.p_05;

import java.util.List;
import java.util.stream.Collectors;

public class TruckServiceImpl implements TruckService {
    @Override
    public List<String> getEngineModel(List<Truck> trucks) {
        List<String> engineModels = trucks
                .stream()
                .map(t -> t.getEngine().getModel())
                .distinct()
                .collect(Collectors.toList ());
        return engineModels;
    }

    @Override
    public List<String> getWheelMakers(List<Truck> trucks) {
        List<String> makers = trucks.stream()
                .map(truck -> truck.getWheels())
                .flatMap(wheels -> wheels.stream())
                .map(wheel -> wheel.getMaker())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return makers;
    }
}
