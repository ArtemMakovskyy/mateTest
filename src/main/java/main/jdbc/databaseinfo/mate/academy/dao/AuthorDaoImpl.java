package main.jdbc.databaseinfo.mate.academy.dao;

import main.jdbc.databaseinfo.mate.academy.lib.Dao;
import main.jdbc.databaseinfo.mate.academy.model.Author;
import main.jdbc.databaseinfo.mate.academy.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author get(Long authorId) {
        String getQuery = "SELECT * FROM authors WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getStatement = connection.prepareStatement(getQuery)) {
            getStatement.setLong(1, authorId);
            ResultSet resultSet = getStatement.executeQuery();
            if(resultSet.next()){
                return getAuthorFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Author();
    }
    private Author getAuthorFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String lastname = resultSet.getString("lastname");
        return new Author(id,name,lastname);
    }
}
