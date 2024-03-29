package main.SOLID.task.basesyntax.service.impl;



import main.SOLID.task.basesyntax.exception.FruitShopException;
import main.SOLID.task.basesyntax.service.ParseDataService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDataServiceImpl implements ParseDataService {
    private static final String DELIMITER = ",";

    @Override
    public List<String[]> parseData(String data) {
        if (data == null || data.length() < 1) {
            throw new FruitShopException("Enter correct string");
        }
        String[] splittedBySeparator = data.split(System.lineSeparator());
        return Arrays.stream(splittedBySeparator)
                .skip(1)
                .map(w -> w.split(DELIMITER))
                .collect(Collectors.toList());
    }
}