package main.jdbc.databaseinfo.mate.academy.service;

import main.jdbc.databaseinfo.mate.academy.model.Book;

public interface BookService {
    Book create (Book book);
    Book get(Long id);

    boolean delete(Long id);

    Book update(Book book);
}
