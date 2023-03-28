package main.jdbc.databaseinfo.mate.academy.service;

import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;

import java.util.List;

public interface LiteraryFormatService {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    LiteraryFormat get(Long id);

    LiteraryFormat update(LiteraryFormat format);

    boolean delete(Long id);

}
