package main.jdbc.databaseinfo.mate.academy.dao;


import main.jdbc.databaseinfo.mate.academy.model.Book;

public interface BookDao {
    Book create (Book book);
    Book get(Long id);

    boolean delete(Long id);

    Book update(Book book);
}
