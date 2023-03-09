package main.SOLID.task.basesyntax;


import main.SOLID.task.basesyntax.service.*;
import main.SOLID.task.basesyntax.service.impl.*;

import java.util.List;

public class Main {
//    https://github.com/Avassor3000/jv-fruit-shop/tree/dev-avassor/src/main
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService readFromFile = new FileReaderServiceImpl();
        ParseDataService parseDataService = new ParseDataServiceImpl();
        DataProcessorService dataProcessorService = new DataProcessorServiceImpl();
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        String data = readFromFile.readFile(INPUT_FILE_PATH);
        List<String[]> list = parseDataService.parseData(data);
        dataProcessorService.processData(list);
        String report = reportCreatorService.createReport();
        fileWriterService.writeToFile(report, OUTPUT_FILE_PATH);

    }
}