package main.dependancy_injection._practice.java.core.basesyntax.strategy;

import main.dependancy_injection._practice.java.core.basesyntax.db.Storage;
import main.dependancy_injection._practice.java.core.basesyntax.lib.MyInject;
import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;

import java.util.HashMap;
import java.util.Map;

public class OperationHandlerStrategy {

//    private Map<FruitTransaction.Operation,
//            OperationHandler> handlerMap = new HashMap<>(Storage.HANDLER_MAP);

//    public OperationHandlerStrategy(Map<FruitTransaction.Operation,
//            OperationHandler> handlerMap) {
//        this.handlerMap = handlerMap;
//    }

    public OperationHandler get(FruitTransaction transaction) {
        System.out.println(Storage.HANDLER_MAP);
        operationVerification(transaction.getOperation());
        return Storage.HANDLER_MAP.get(transaction.getOperation());
    }

    private void operationVerification(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation shouldn't be null");
        }
        if (!Storage.HANDLER_MAP.containsKey(operation)) {
            throw new RuntimeException("Have to create strategy of operator "
                    + operation + ". It doesn't exist");
        }
    }
}
