package work.task.task2;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    private final static List<City> cities = CityRepository.loadData();

    public static void findMinCostBetweenCities(String from, String to) {
        City startCity = findCityByName(cities, from);
        City endCity = findCityByName(cities, to);
        int minCost = findMinCostBetweenCities(startCity, endCity, new ArrayList<>(), 0, cities);
        System.out.println("Minimum cost from " + startCity.getName() + " to " + endCity.getName() + " is: " + minCost);
    }

    private static int findMinCostBetweenCities(City currentCity, City destinationCity, List<City> visitedCities, int currentCost, List<City> cities) {
        // If the current city has already been visited, exit to avoid looping
        if (visitedCities.contains(currentCity)) {
            // Return the maximum value since the path cannot be selected
            return Integer.MAX_VALUE;
        }

        // If we have reached the target city, we return the cost of the current path
        if (currentCity == destinationCity) {
            return currentCost;
        }

        // Add the current city to the list of visited cities
        visitedCities.add(currentCity);

        int minCost = Integer.MAX_VALUE;

        // Recursively find the minimum cost for all neighbors
        for (Neighbor neighbor : currentCity.getNeighbors()) {
            City nextCity = findCityById(cities, neighbor.getNeighborId());
            if (nextCity != null) {

                int pathCost = findMinCostBetweenCities(
                        nextCity,
                        destinationCity,
                        new ArrayList<>(visitedCities),
                        currentCost + neighbor.getCost(),
                        cities);

                minCost = Math.min(minCost, pathCost);
            }
        }
        return minCost;
    }

    private static City findCityByName(List<City> cities, String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    private static City findCityById(List<City> cities, int id) {
        for (City city : cities) {
            if (city.getId() == id) {
                return city;
            }
        }
        return null;
    }
}
