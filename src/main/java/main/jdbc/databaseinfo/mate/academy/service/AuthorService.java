package main.jdbc.databaseinfo.mate.academy.service;

import main.jdbc.databaseinfo.mate.academy.model.Author;

public interface AuthorService {
    Author get(Long authorId);
}
