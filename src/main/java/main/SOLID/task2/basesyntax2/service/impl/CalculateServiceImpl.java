package main.SOLID.task2.basesyntax2.service.impl;

import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.service.CalculateService;
import main.SOLID.task2.basesyntax2.strategy.FruitsStrategy;
import main.SOLID.task2.basesyntax2.strategy.OperationHandle;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    FruitsStrategy fruitsStrategy;

    public CalculateServiceImpl(FruitsStrategy fruitsStrategy) {
        this.fruitsStrategy = fruitsStrategy;
    }

    @Override
    public void process(List<FruitTransaction> list) {

        for (FruitTransaction fruitTransaction : list) {
            OperationHandle handle = fruitsStrategy.handle(fruitTransaction.getOperation());
            handle.process(fruitTransaction);
        }
    }
}
