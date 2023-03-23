package main.jdbc.account.servce;

import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;

import java.util.List;

public interface LiteraryFormatService {
    List<LiteraryFormat>getAll();
    LiteraryFormat create(LiteraryFormat literaryFormat);
    LiteraryFormat get(Long id);
    LiteraryFormat update (LiteraryFormat literaryFormat);
    boolean delete (Long id);
}
