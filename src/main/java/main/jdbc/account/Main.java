package main.jdbc.account;

import main.jdbc.account.servce.LiteraryFormatService;
import main.jdbc.account.util.Injector;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDao;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDaoImpl;
import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;

public class Main {
    private static Injector injector= Injector.getInstance("src/main/java/main/jdbc/account");
    public static void main(String[] args) {
        LiteraryFormatService literaryFormatService = (LiteraryFormatService)
                injector.getInstance(LiteraryFormatService.class);
        literaryFormatService.getAll().forEach(System.out::println);
    }
}
