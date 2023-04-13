package main.collection.map.hashMap.market;

import java.util.HashMap;
import java.util.Map;

public class MarketSupplying {
    public Map<String, Integer> supplyFruits(Map<String, Integer> storage, int supply) {
        Map<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> item : storage.entrySet()) {
//            item.setValue(supply*2);
            if (storage.containsKey(item.getKey())) {
                newMap.put(item.getKey(), item.getValue() + supply);
            } else {
                newMap.put(item.getKey(), supply);
            }
        }

        return newMap;
    }
}
