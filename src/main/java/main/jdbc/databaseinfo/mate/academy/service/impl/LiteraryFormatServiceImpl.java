package main.jdbc.databaseinfo.mate.academy.service.impl;

import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDao;
import main.jdbc.databaseinfo.mate.academy.lib.Inject;
import main.jdbc.databaseinfo.mate.academy.lib.Service;
import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;
import main.jdbc.databaseinfo.mate.academy.service.LiteraryFormatService;

import java.util.List;

@Service
public class LiteraryFormatServiceImpl implements LiteraryFormatService {
    @Inject
    LiteraryFormatDao literaryFormatDao;

    @Override
    public List<LiteraryFormat> getAll() {
        return literaryFormatDao.getAll();
    }

    @Override
    public LiteraryFormat create(LiteraryFormat format) {
        return literaryFormatDao.create(format);
    }

    @Override
    public LiteraryFormat get(Long id) {
        return literaryFormatDao.get(id);
    }

    @Override
    public LiteraryFormat update(LiteraryFormat format) {
        return literaryFormatDao.update(format);
    }

    @Override
    public boolean delete(Long id) {
        return literaryFormatDao.delete(id);
    }
}
