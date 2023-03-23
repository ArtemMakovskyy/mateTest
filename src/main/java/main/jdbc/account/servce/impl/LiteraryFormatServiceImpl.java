package main.jdbc.account.servce.impl;

import main.dependancy_injection.lib.Inject;
import main.jdbc.account.lib.Service;
import main.jdbc.account.servce.LiteraryFormatService;
import main.jdbc.databaseinfo.mate.academy.dao.LiteraryFormatDao;
import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;

import java.util.List;
@Service
public class LiteraryFormatServiceImpl implements LiteraryFormatService {
    @Inject
    private LiteraryFormatDao literaryFormatDao;

    @Override
    public List<LiteraryFormat> getAll() {
        return literaryFormatDao.getAll();
    }

    @Override
    public LiteraryFormat create(LiteraryFormat literaryFormat) {
        return literaryFormatDao.create(literaryFormat);
    }

    @Override
    public LiteraryFormat get(Long id) {
        return literaryFormatDao.get(id);
    }

    @Override
    public LiteraryFormat update(LiteraryFormat literaryFormat) {
        return literaryFormatDao.update(literaryFormat);
    }

    @Override
    public boolean delete(Long id) {
        return literaryFormatDao.delete(id);
    }
}
