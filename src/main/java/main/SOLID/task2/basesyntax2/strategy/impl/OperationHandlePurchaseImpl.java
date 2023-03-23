package main.SOLID.task2.basesyntax2.strategy.impl;


import main.SOLID.task2.basesyntax2.db.Storage;
import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.strategy.OperationHandle;

public class OperationHandlePurchaseImpl implements OperationHandle {
    Storage storage;

    public OperationHandlePurchaseImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Integer quantiteBefore = storage.FRUIT_BALANCE.get(transaction.getFruit());
        storage.FRUIT_BALANCE.put(transaction.getFruit(),quantiteBefore - transaction.getQuantity());
    }
}
