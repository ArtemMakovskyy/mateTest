package main.collection.map.hashMap.collision;

import java.util.HashMap;
import java.util.Map;

public class Information {
    public static void main(String[] args) {
        Map<String, String> capitalCities = new HashMap<>();
        capitalCities.put("England","London");
        capitalCities.put("Germany","Berlin");
        capitalCities.put("Norway","Oslo");
        capitalCities.put("Ukraine","Kyiv");
        System.out.println(capitalCities);

        Map<String, Integer> population = new HashMap<>();
        population.put("England",1);
        population.put("Germany",2);
        population.put("Norway",3);
        population.put("Ukraine",35_000_000);

        System.out.println(capitalCities.get("Ukraine"));
        System.out.println(population.get("Ukraine"));
        System.out.println(capitalCities.keySet());
        System.out.println(capitalCities.values());
    }
}
