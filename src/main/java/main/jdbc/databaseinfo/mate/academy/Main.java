package main.jdbc.databaseinfo.mate.academy;

import main.jdbc.databaseinfo.mate.academy.dao.BookDao;
import main.jdbc.databaseinfo.mate.academy.dao.BookDaoImpl;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDao;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDaoImpl;
import main.jdbc.databaseinfo.mate.academy.lib.Injector;
import main.jdbc.databaseinfo.mate.academy.model.Author;
import main.jdbc.databaseinfo.mate.academy.model.Book;
import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;
import main.jdbc.databaseinfo.mate.academy.service.AuthorService;
import main.jdbc.databaseinfo.mate.academy.service.BookService;
import main.jdbc.databaseinfo.mate.academy.service.LiteraryFormatService;
import main.jdbc.databaseinfo.mate.academy.util.ConnectionUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Injector injector = Injector.getInstance("main.jdbc.databaseinfo.mate.academy");
    public static void main(String[] args) {
        AuthorService authorService = (AuthorService) injector.getInstance(AuthorService.class);
        LiteraryFormatService literaryFormatService = (LiteraryFormatService) injector.getInstance(LiteraryFormatService.class);
//        literaryFormatService.create(new LiteraryFormat("religion"));
//        System.out.println(literaryFormatService.getAll());

        BookService bookService = (BookService) injector.getInstance(BookService.class);
//        Book bhagavatGita = new Book(
//                "Bhagavat Gita",
//                BigDecimal.valueOf(500),
//                literaryFormatService.get(25L),
//                List.of(authorService.get(4L)));
//        bookService.create(bhagavatGita);
//        System.out.println(bookService.get(3L));

                Book someUpdateBook = new Book(4L,
                "update Book 2",
                BigDecimal.valueOf(500),
                literaryFormatService.get(21L),
                List.of(authorService.get(1L),authorService.get(2L),authorService.get(3L)));
                System.out.println(bookService.get(4L));
        System.out.println(someUpdateBook);
        bookService.update(someUpdateBook);

    }
}
