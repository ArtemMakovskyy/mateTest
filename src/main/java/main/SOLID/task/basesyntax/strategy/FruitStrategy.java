package main.SOLID.task.basesyntax.strategy;



import main.SOLID.task.basesyntax.exception.FruitShopException;
import main.SOLID.task.basesyntax.strategy.impl.BalanceFruitCalculatorService;
import main.SOLID.task.basesyntax.strategy.impl.PurchaseFruitCalculatorService;
import main.SOLID.task.basesyntax.strategy.impl.ReturnFruitCalculatorService;
import main.SOLID.task.basesyntax.strategy.impl.SupplyFruitCalculatorService;

import java.util.HashMap;
import java.util.Map;

public class FruitStrategy {
    public static final Map<String, FruitCalculatorService> keyStorage;

    static {
        keyStorage = new HashMap<>();
        keyStorage.put("b", new BalanceFruitCalculatorService());
        keyStorage.put("p", new PurchaseFruitCalculatorService());
        keyStorage.put("r", new ReturnFruitCalculatorService());
        keyStorage.put("s", new SupplyFruitCalculatorService());
    }

    public FruitCalculatorService getFruitService(String operation) {
        if (operation == null || operation.isEmpty()) {
            throw new FruitShopException("String operation should not be null or empty");
        }
        if (!keyStorage.containsKey(operation)) {
            throw new FruitShopException("Operation is wrong");
        }
        return keyStorage.get(operation);
    }
}