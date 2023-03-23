package main.SOLID.task2.basesyntax2.service;

import main.SOLID.task2.basesyntax2.model.FruitTransaction;

import java.util.List;

public interface ParseService {
    List<FruitTransaction> process(List<String> list);
}
