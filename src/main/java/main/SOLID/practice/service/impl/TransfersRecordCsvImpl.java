package main.SOLID.practice.service.impl;

import main.SOLID.practice.model.OrderTransactions;
import main.SOLID.practice.service.TransfersRecordCsv;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TransfersRecordCsvImpl implements TransfersRecordCsv {
    @Override
    public void wright(OrderTransactions set) {
        File file = new File("src/main/resources/transfersList.csv");
//        List<OrderTransactions> orderTransactionsList = new ArrayList<>();
        try {
            String info = set.getAccountFrom() + "," + set.getAccountTo() + "," + set.getAmount() + "," + set.getCommission() + "," + set.getCommissionChar() + System.lineSeparator();
            Files.write(file.toPath(), info.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
