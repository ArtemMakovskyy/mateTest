package main.SOLID.task.basesyntax.strategy.impl;


import main.SOLID.task.basesyntax.exception.FruitShopException;
import main.SOLID.task.basesyntax.strategy.FruitCalculatorService;

public class PurchaseFruitCalculatorService implements FruitCalculatorService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        if (startAmount < 0 || amountToOperate < 0) {
            throw new FruitShopException("Amount of fruits should be grater than 0");
        }
        if (startAmount - amountToOperate < 0) {
            throw new FruitShopException("Remainder should not be less than 0");
        }
        return startAmount - amountToOperate;
    }
}