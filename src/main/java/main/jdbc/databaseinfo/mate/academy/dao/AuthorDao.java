package main.jdbc.databaseinfo.mate.academy.dao;

import main.jdbc.databaseinfo.mate.academy.model.Author;

public interface AuthorDao {
    Author get(Long authorId);
}
