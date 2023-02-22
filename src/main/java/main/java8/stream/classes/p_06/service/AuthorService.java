package main.java8.stream.classes.p_06.service;

import main.java8.stream.classes.p_06.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getMPByAA(int fromAge, int toAge);
}
