package main.SOLID.task2.basesyntax2.db;

import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.strategy.OperationHandle;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String,Integer> FRUIT_BALANCE = new HashMap<>();
}
