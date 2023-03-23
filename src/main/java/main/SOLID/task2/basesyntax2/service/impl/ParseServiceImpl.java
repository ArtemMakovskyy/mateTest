package main.SOLID.task2.basesyntax2.service.impl;

import main.SOLID.task2.basesyntax2.model.FruitTransaction;
import main.SOLID.task2.basesyntax2.service.ParseService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    @Override
    public List<FruitTransaction> process(List<String> transactions) {
        return transactions.stream()
                .skip(1)
                .map(t -> createTransaction(t))
                .collect(Collectors.toList());
    }
    private FruitTransaction createTransaction(String line){
        String[] transactionList = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getOperation(
                        transactionList[0].trim()));
        fruitTransaction.setFruit(transactionList[1]);
        fruitTransaction.setQuantity(Integer.parseInt(transactionList[2]));
        return fruitTransaction;
    }
}
