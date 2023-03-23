package main.SOLID.task2.basesyntax2.strategy;

import main.SOLID.task2.basesyntax2.db.Storage;
import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandleBalanceImpl;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandlePurchaseImpl;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandleReturnImpl;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandleSupplyImpl;

import java.util.HashMap;
import java.util.Map;

public class FruitsStrategy {
    private Map<FruitTransaction.Operation, OperationHandle> handleStrategy;

    public FruitsStrategy(Map<FruitTransaction.Operation, OperationHandle> handleStrategy) {
        this.handleStrategy = handleStrategy;
    }

    public OperationHandle handle(FruitTransaction.Operation operation) {
        return handleStrategy.get(operation);
    }
}
