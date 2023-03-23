package main.jdbc.databapractice.dao;

import main.jdbc.databapractice.model.TeaSort;
import main.jdbc.databapractice.util.SqlConnection;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class TeaSortsDaoImpl implements TeaSortsDao {
    private static final String TABLE = "tea_sorts";
    @Override
    public TeaSort create(TeaSort teaSort) {
        String insertQuery = "INSERT INTO " + TABLE + " (name, price) VALUES (?, ?)";
        try(Connection connection = SqlConnection.getConnection();
            PreparedStatement createStatement = connection.prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1,teaSort.getName());
            createStatement.setDouble(2,teaSort.getPrice());
            createStatement.executeUpdate();
            ResultSet generatedKeys = createStatement.getGeneratedKeys();
           if (generatedKeys.next()){
               Long id = generatedKeys.getObject(1, Long.class);
               teaSort.setId(id);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teaSort;
    }

    @Override
    public Optional<TeaSort> get(Long id) {
        TeaSort teaSort = new TeaSort();
        String getQuery = "Select * FROM " + TABLE + " WHERE id = ? AND is_deleted = FALSE";
        try (PreparedStatement getStatement =
                     SqlConnection.getConnection().prepareStatement(getQuery)) {
            getStatement.setLong(1,id);
            ResultSet resultSet = getStatement.executeQuery();
            if (resultSet.next()){
                teaSort = getTeaSortWithResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(teaSort);
    }

    public Optional<TeaSort> get(String name) {
        TeaSort teaSort = new TeaSort();
        String getQuery = "Select * FROM " + TABLE + " WHERE name = ? AND is_deleted = FALSE";
        try (PreparedStatement getStatement =
                     SqlConnection.getConnection().prepareStatement(getQuery)) {
            getStatement.setString(1, name);
            ResultSet resultSet = getStatement.executeQuery();
            if (resultSet.next()) {
                teaSort = getTeaSortWithResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(teaSort);
    }

    @Override
    public List<TeaSort> getAll() {
        return null;
    }

    @Override
    public TeaSort update(TeaSort kind) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    private TeaSort getTeaSortWithResultSet(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject(1, Long.class);
            String name = resultSet.getString(2);
            Double price = resultSet.getObject(3, Double.class);
            return new TeaSort(id, name, price);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
