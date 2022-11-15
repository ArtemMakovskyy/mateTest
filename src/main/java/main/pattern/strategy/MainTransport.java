package main.pattern.strategy;

public class MainTransport {
    public static void main(String[] args) {
        RouteStrategy routeStrategy = new RouteStrategy();
        RouteService routeService = routeStrategy.getRouteService("walk");
        System.out.println(routeService.calculateRouteTime(10,110));

    }
}
