package main.dependancy_injection._practice.java.core.basesyntax.db;

import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.OperationHandler;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.OperationHandlerStrategy;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerBalanceImpl;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerPurchaseImpl;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerReturnImpl;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerSupplyImpl;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> STOCK_BALANCE = new HashMap<>();
    public static Map<FruitTransaction.Operation, OperationHandler> HANDLER_MAP
            = Map.of(
            FruitTransaction.Operation.BALANCE, new OperationHandlerBalanceImpl(new Storage()),
            FruitTransaction.Operation.PURCHASE, new OperationHandlerPurchaseImpl(new Storage()),
            FruitTransaction.Operation.RETURN, new OperationHandlerReturnImpl(new Storage()),
            FruitTransaction.Operation.SUPPLY, new OperationHandlerSupplyImpl(new Storage())
    );

//    {
//        HANDLER_MAP.put(FruitTransaction.Operation.BALANCE,
//                new OperationHandlerBalanceImpl(this));
//        HANDLER_MAP.put(FruitTransaction.Operation.PURCHASE,
//                new OperationHandlerPurchaseImpl(this));
//        HANDLER_MAP.put(FruitTransaction.Operation.RETURN,
//                new OperationHandlerReturnImpl(this));
//        HANDLER_MAP.put(FruitTransaction.Operation.SUPPLY,
//                new OperationHandlerSupplyImpl(this));
//    }
}
