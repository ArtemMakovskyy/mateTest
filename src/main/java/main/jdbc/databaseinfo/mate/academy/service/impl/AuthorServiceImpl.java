package main.jdbc.databaseinfo.mate.academy.service.impl;

import main.jdbc.databaseinfo.mate.academy.dao.AuthorDao;
import main.jdbc.databaseinfo.mate.academy.lib.Inject;
import main.jdbc.databaseinfo.mate.academy.lib.Service;
import main.jdbc.databaseinfo.mate.academy.model.Author;
import main.jdbc.databaseinfo.mate.academy.service.AuthorService;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
   private AuthorDao authorDao;

    @Override
    public Author get(Long authorId) {
        return authorDao.get(authorId);
    }
}
