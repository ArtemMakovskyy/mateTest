package main.pattern.strategy;

import main.pattern.strategy.RouteService;
import main.pattern.strategy.imp.BikeTransportService;
import main.pattern.strategy.imp.CarRoutService;
import main.pattern.strategy.imp.PublicTransportService;
import main.pattern.strategy.imp.WalkingTransportService;

public class RouteStrategy {
    public RouteService getRouteService(String transportType) {
        switch (transportType) {
            case ("byke"):
                return new BikeTransportService();
            case ("walk"):
                return new WalkingTransportService();
            case ("publik"):
                return new PublicTransportService();
            case ("car"):
            default:
                return new CarRoutService();
        }
    }
}
