package main.jdbc.databaseinfo.mate.academy;

import main.jdbc.databaseinfo.mate.academy.dao.BookDao;
import main.jdbc.databaseinfo.mate.academy.dao.BookDaoImpl;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDao;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDaoImpl;
import main.jdbc.databaseinfo.mate.academy.model.Book;
import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        LiteraryFormat format = new LiteraryFormat();
//        format.setFormat("proza");

        LiteraryFormatDao literaryFormatDao = new LiteraryFormatDaoImpl();
//        LiteraryFormat savedFormat = literaryFormatDao.create(format);
//        System.out.println(savedFormat + "\n");
//        literaryFormatDao.delete(17L);
//        System.out.println(literaryFormatDao.get(21L));
        literaryFormatDao.getAll().stream().forEach(System.out::println);

        BookDao bookDao = new BookDaoImpl();
//        bookDao.create(new Book("tittle", BigDecimal.valueOf(100),literaryFormatDao.get(21L)));
        Book book1 = bookDao.get(1L);
        Book book2 = bookDao.get(2L);
        System.out.println(book1);
        System.out.println(book2);




    }
}
