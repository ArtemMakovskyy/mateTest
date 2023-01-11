package main.collection.hashMap.market;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer>storage
                = new HashMap<>(Map.of("Apple",10,"Orange",20));
        MarketSupplying ms  = new MarketSupplying();
//        ms.supplyFruits()
    }
}
