package main.jdbc.databaseinfo.mate.academy.service.impl;

import main.jdbc.databaseinfo.mate.academy.dao.BookDao;
import main.jdbc.databaseinfo.mate.academy.lib.Inject;
import main.jdbc.databaseinfo.mate.academy.lib.Service;
import main.jdbc.databaseinfo.mate.academy.model.Book;
import main.jdbc.databaseinfo.mate.academy.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book create(Book book) {
        return bookDao.create(book);
    }

    @Override
    public Book get(Long id) {
        return bookDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return bookDao.delete(id);
    }

    @Override
    public Book update(Book book) {
        return bookDao.update(book);
    }
}
