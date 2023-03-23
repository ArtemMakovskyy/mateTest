package main.SOLID.task2.basesyntax2;

import main.SOLID.task2.basesyntax2.db.Storage;
import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.service.*;
import main.SOLID.task2.basesyntax2.service.impl.*;
import main.SOLID.task2.basesyntax2.strategy.FruitsStrategy;
import main.SOLID.task2.basesyntax2.strategy.OperationHandle;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandleBalanceImpl;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandlePurchaseImpl;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandleReturnImpl;
import main.SOLID.task2.basesyntax2.strategy.impl.OperationHandleSupplyImpl;

import java.util.List;
import java.util.Map;

public class Start {
    private static final String inputFileWithListOperation = "src/main/resources/input.csv";
    private static final String outputfile = "src/main/resources/output2.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        ReadService readService = new ReadServiceImpl();
        List<String> read = readService.read(inputFileWithListOperation);

        ParseService parse = new ParseServiceImpl();
        List<FruitTransaction> transactions = parse.process(read);

        CalculateService calculateService = new CalculateServiceImpl(
                new FruitsStrategy(handleStrategy(storage)));
        calculateService.process(transactions);

        ReportService reportService = new ReportServiceImpl(storage);
        String report = reportService.get();

        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, outputfile);
    }

    private static Map<FruitTransaction.Operation,
            OperationHandle> handleStrategy(Storage storage) {
        return Map.of(FruitTransaction.Operation.BALANCE,
                new OperationHandleBalanceImpl(storage),
                FruitTransaction.Operation.SUPPLY,
                new OperationHandleSupplyImpl(storage),
                FruitTransaction.Operation.RETURN,
                new OperationHandleReturnImpl(storage),
                FruitTransaction.Operation.PURCHASE,
                new OperationHandlePurchaseImpl(storage));
    }
}
