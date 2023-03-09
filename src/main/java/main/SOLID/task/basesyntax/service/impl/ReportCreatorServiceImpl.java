package main.SOLID.task.basesyntax.service.impl;


import main.SOLID.task.basesyntax.db.Storage;
import main.SOLID.task.basesyntax.service.ReportCreatorService;

import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    public String createReport() {
        if (Storage.mapFruits.isEmpty()) {
            throw new RuntimeException("Report of the day doesn't exist");
        }
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.mapFruits.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}