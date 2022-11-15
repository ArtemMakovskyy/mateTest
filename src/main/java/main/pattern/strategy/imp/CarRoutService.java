package main.pattern.strategy.imp;

import main.pattern.strategy.RouteService;

public class CarRoutService implements RouteService {

    @Override
    public double calculateRouteTime(int firstPoint, int secondPoint) {
        return (secondPoint - firstPoint) / 50;
    }
}
