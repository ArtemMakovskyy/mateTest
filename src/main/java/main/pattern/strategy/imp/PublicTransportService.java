package main.pattern.strategy.imp;

import main.pattern.strategy.RouteService;

public class PublicTransportService implements RouteService {
    @Override
    public double calculateRouteTime(int firstPoint, int secondPoint) {
        return (secondPoint - firstPoint) / 35;
    }
}
