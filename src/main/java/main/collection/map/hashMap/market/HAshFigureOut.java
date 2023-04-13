package main.collection.map.hashMap.market;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HAshFigureOut {
    public static void main(String[] args) {
        Map<String, Integer> map
                = new HashMap<>(Map.of("Apple", 10, "Orange", 20));

        Map<String, Integer> newMap = new HashMap<>();

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + ", " + item.getValue());
            if (map.containsKey(item.getKey())) {
                newMap.put(item.getKey(), item.getValue() + 10);
            } else {
                newMap.put("new", 99);
            }
        }
        System.out.println(newMap);
    }
}
