package main.jdbc.databaseinfo.mate.academy.dao;

import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;

import java.util.List;
//CRUD
public interface LiteraryFormatDao {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    LiteraryFormat get(Long id);

    LiteraryFormat update(LiteraryFormat format);

    boolean delete(Long id);

}
