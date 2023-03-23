package main.SOLID.task2.basesyntax2.strategy;

import main.SOLID.task2.basesyntax2.model.FruitTransaction;

public interface OperationHandle {
  void process(FruitTransaction transaction);
}
