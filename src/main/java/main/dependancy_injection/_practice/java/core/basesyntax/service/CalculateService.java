package main.dependancy_injection._practice.java.core.basesyntax.service;

import main.dependancy_injection._practice.java.core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface CalculateService {
    public void process(List<FruitTransaction> list);
}
