package main.dependancy_injection._practice.java.core.basesyntax.strategy;

import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
