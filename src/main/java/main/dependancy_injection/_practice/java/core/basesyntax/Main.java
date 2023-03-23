package main.dependancy_injection._practice.java.core.basesyntax;

import main.dependancy_injection._practice.java.core.basesyntax.app.Starter;
import main.dependancy_injection._practice.java.core.basesyntax.db.Storage;
import main.dependancy_injection._practice.java.core.basesyntax.lib.Injector;
import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;
import main.dependancy_injection._practice.java.core.basesyntax.service.*;
import main.dependancy_injection._practice.java.core.basesyntax.service.impl.*;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.OperationHandler;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.OperationHandlerStrategy;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerBalanceImpl;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerPurchaseImpl;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerReturnImpl;
import main.dependancy_injection._practice.java.core.basesyntax.strategy.impl.OperationHandlerSupplyImpl;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPERATIONS_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
//        oldStart();
        newStart(false,false,true);
    }
    private static void newStart(boolean first,boolean second,boolean third){
        Injector injector = Injector.getInjector();
        ReadService readService = (ReadService) injector.getInstance(ReadService.class);
        List<String> fruitsOperations = readService.read(new File(OPERATIONS_FILE));
        if (first)  fruitsOperations.stream().forEach(System.out::println);

        TransactionParser parser = (TransactionParser) injector.getInstance(TransactionParser.class);
        List<FruitTransaction> parse = parser.parse(fruitsOperations);
        if (second)  parse.stream().forEach(System.out::println);

        CalculateService calculateService = (CalculateService) injector.getInstance(CalculateServiceImpl.class);
        calculateService.process(parse);
    }
    private static void oldStart(){
        Storage storage = new Storage();
        Map<FruitTransaction.Operation,
                OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new OperationHandlerBalanceImpl(storage));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationHandlerPurchaseImpl(storage));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new OperationHandlerReturnImpl(storage));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationHandlerSupplyImpl(storage));

        ReadService readService = new ReadServiceImpl();
        List<String> fruitsOperations = readService.read(new File(OPERATIONS_FILE));

        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> fruitsTransactions
                = parser.parse(fruitsOperations);

//        CalculateService calculateService
//                = new CalculateServiceImpl(new OperationHandlerStrategy(handlerMap));
//        calculateService.process(fruitsTransactions);

        ReportService reportService = new ReportServiceImpl(storage);
        String report = reportService.getReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, REPORT_FILE);
    }
}
