package main.stream.classes.p_06.service;

import main.stream.classes.p_06.db.Storage;
import main.stream.classes.p_06.model.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> getMPByAA(int fromAge, int toAge) {
        List<Author> authorList = Storage.getStatistic()
                .entrySet().stream()
                .filter(e -> e.getKey().getAge() > fromAge && e.getKey().getAge() < toAge)
                .map(u -> u.getValue())
                .flatMap(books -> books.stream())
                .map(book -> book.getAuthor())
                .distinct()
                .collect(Collectors.toList());
        return authorList;
    }
}
