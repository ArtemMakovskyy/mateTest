package main.dependancy_injection._practice.java.core.basesyntax.service.impl;

import main.dependancy_injection._practice.java.core.basesyntax.lib.MyInject;
import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;
import main.dependancy_injection._practice.java.core.basesyntax.service.CalculateService;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.OperationHandler;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.OperationHandlerStrategy;

import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    @MyInject
    private OperationHandlerStrategy operationHandlerStrategy;

//    public CalculateServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
//        this.operationHandlerStrategy = operationHandlerStrategy;
//    }

    @Override
    public void process(List<FruitTransaction> list) {
        for (FruitTransaction transaction : list) {
            OperationHandler handler = operationHandlerStrategy.get(transaction);
            handler.handle(transaction);
        }
    }
}
