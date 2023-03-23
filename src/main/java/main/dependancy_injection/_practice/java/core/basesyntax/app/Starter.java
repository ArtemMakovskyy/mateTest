package main.dependancy_injection._practice.java.core.basesyntax.app;

import main.SOLID.task2.basesyntax2.service.ReadService;
import main.SOLID.task2.basesyntax2.service.impl.ReadServiceImpl;
import main.dependancy_injection._practice.java.core.basesyntax.db.Storage;
import main.dependancy_injection._practice.java.core.basesyntax.lib.Injector;
import main.dependancy_injection._practice.java.core.basesyntax.lib.MyInject;
import main.dependancy_injection._practice.java.core.basesyntax.service.CalculateService;
import main.dependancy_injection._practice.java.core.basesyntax.service.TransactionParser;

import java.io.File;
import java.util.List;

public class Starter {
    private static final String OPERATIONS_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/output.csv";
    @MyInject
    Storage storage;
    @MyInject
    ReadService readService;
    @MyInject
    TransactionParser parser;
//    @MyInject
//    CalculateService calculateService;

    public void start() {
//        readService = new ReadServiceImpl();
        List<String> stringList = readService.read(OPERATIONS_FILE);
//        stringList.stream().forEach(System.out::println);
    }
}
