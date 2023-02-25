package main.SOLID._03_LSP.db;

import lombok.*;
import main.SOLID._03_LSP.model.Account;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountStorage {
    public static final List<Account> storage = new ArrayList<>();
}
