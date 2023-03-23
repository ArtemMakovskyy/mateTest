package main.SOLID.task2.basesyntax2.service.impl;

import main.SOLID.task2.basesyntax2.db.Storage;
import main.SOLID.task2.basesyntax2.service.ReportService;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    Storage storage;

    public ReportServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String get() {
        StringBuilder sb = new StringBuilder("fruit,quantity");
        if (storage.FRUIT_BALANCE.isEmpty()) {
            return sb.toString();
        }
        for (Map.Entry<String, Integer> entry : storage.FRUIT_BALANCE.entrySet()) {
            sb.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }

        return sb.toString();
    }
}
