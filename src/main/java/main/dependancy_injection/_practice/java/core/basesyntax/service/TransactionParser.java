package main.dependancy_injection._practice.java.core.basesyntax.service;

import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parse(List<String> list);
}
