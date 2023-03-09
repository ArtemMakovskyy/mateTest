package main.SOLID.task.basesyntax.service.impl;


import main.SOLID.task.basesyntax.db.Storage;
import main.SOLID.task.basesyntax.exception.FruitShopException;
import main.SOLID.task.basesyntax.service.DataProcessorService;
import main.SOLID.task.basesyntax.strategy.FruitStrategy;

import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final FruitStrategy fruitStrategy = new FruitStrategy();

    @Override
    public void processData(List<String[]> lines) {
        if (lines == null || lines.size() < 1) {
            throw new FruitShopException("The input data is null or empty");
        }
        for (String[] line: lines) {
            String key = line[FRUIT_INDEX];
            boolean isOperation = fruitStrategy.keyStorage
                    .containsKey(line[OPERATION_INDEX].trim());
            int oldAmount = Storage.mapFruits.getOrDefault(key, 0);
            System.out.println("oldAmount " + oldAmount);
            int newAmount = Integer.parseInt(line[AMOUNT_INDEX]);
            if (!isOperation) {
                throw new FruitShopException("The operation string is incorrect");
            }
            Storage.mapFruits.put(line[FRUIT_INDEX].trim(),
                    fruitStrategy.getFruitService(line[OPERATION_INDEX].trim())
                            .calculateFruits(oldAmount, newAmount));
        }
    }
}