package main.SOLID.task2.basesyntax2.strategy.impl;


import main.SOLID.task2.basesyntax2.db.Storage;
import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.strategy.OperationHandle;

public class OperationHandleBalanceImpl implements OperationHandle {
    Storage storage;

    public OperationHandleBalanceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        storage.FRUIT_BALANCE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
