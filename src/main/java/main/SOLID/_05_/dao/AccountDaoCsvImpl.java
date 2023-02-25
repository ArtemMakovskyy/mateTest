package main.SOLID._05_.dao;

import main.SOLID._02_OCP.model.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoCsvImpl implements AccountDao{
    private static final String FILE_NAME = "src/main/java/main/SOLID/_05_/database.csv";
    @Override
    public void add(Account account) {

    }

    @Override
    public Account get(String accountNumber) {
        List<String> accounts = new ArrayList<>();
        try {
             accounts = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw  new RuntimeException("Can't read data " + FILE_NAME);
        }
        return accounts.stream()
                .filter(line->line.startsWith(accountNumber))
                .map(this::getFromCsvRow)
                .findFirst().get();
    }

    @Override
    public void update(Account account) {

    }
    private Account getFromCsvRow(String line){
        String[] fields = line.split(",");
        Account account = new Account();
        account.setNumber(fields[0]);
        account.setAmount(new BigDecimal(fields[1]));
        account.setType(Account.Type.valueOf(fields[2]));
        return account;
    }
}
