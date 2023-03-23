package main.jdbc.databaseinfo.mate.academy.dao;

import main.jdbc.databaseinfo.mate.academy.model.Author;
import main.jdbc.databaseinfo.mate.academy.model.Book;
import main.jdbc.databaseinfo.mate.academy.model.LiteraryFormat;
import main.jdbc.databaseinfo.mate.academy.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public Book create(Book book) {
        String insertRequest = "INSERT INTO books (title, price, literary_format_id) VALUES (?,?,?);";
        try (
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createBookStatement = connection.prepareStatement(insertRequest,
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            createBookStatement.setString(1, book.getTitle());
            createBookStatement.setBigDecimal(2, book.getPrice());
            createBookStatement.setLong(3, book.getFormat().getId());
            createBookStatement.executeUpdate();
            ResultSet generatedKeys = createBookStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                book.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert format to DB ");
        }
        insertAuthors(book);
        return book;
    }

    private void insertAuthors(Book book) {
        String insertAuthorQuery =
                "INSERT INTO books_authors (book_id, author_id) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement addAuthorToBookStatement
                     = connection.prepareStatement(insertAuthorQuery)) {
            addAuthorToBookStatement.setLong(1, book.getId());
            for (Author author : book.getAuthors()) {
                addAuthorToBookStatement.setLong(2, author.getId());
                addAuthorToBookStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert Authot to book " + book, e);
        }
    }

    @Override
    public Book get(Long id) {
        String getRequest = "SELECT b.id AS book_id, title, price, lf.id "
                + "AS literary_format_id, lf.format "
                + "FROM books b  join literary_formats lf "
                + "ON b.literary_format_id = lf.id "
                + "WHERE b.id = ? AND b.is_deleted = FALSE;";
        Book book = null;
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getBookStatement
                     = connection.prepareStatement(getRequest)) {
            getBookStatement.setLong(1, id);
            ResultSet resultSet = getBookStatement.executeQuery();
            if (resultSet.next()) {
                book = parseBookWithLiteraryFormatFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        if (book != null) {
            book.setAuthors(getAuthorsForBook(id));
        }
        return book;
    }

    @Override
    public boolean delete(Long bookId) {
        String deleteBookRequest =
                "UPDATE literary_format SET is_deleted = TRUE WHERE id =?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement softDeletedBookStatement =
                     connection.prepareStatement(deleteBookRequest)) {
            softDeletedBookStatement.setLong(1, bookId);
            int numberOfDeletedRows = softDeletedBookStatement.executeUpdate();
            return numberOfDeletedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete book by id " + bookId, e);
        }
    }

    @Override
    public Book update(Book book) {
        // TODO: 1) update books fields
        // TODO: 2) delete all relations in books_authors
        //  table where bookId = book.getId()
        // TODO: 3) add all relations to the books_author table

        return book;
    }

    private List<Author> getAuthorsForBook(Long bookId) {
        String getAllAuthorsFromBookRequest =
                "SELECT id, name, lastname "
                        + "FROM authors a "
                        + "JOIN books_authors ba "
                        + "ON a.id = ba.author_id "
                        + "WHERE ba.book_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllAuthorsStatement = connection.prepareStatement(getAllAuthorsFromBookRequest)) {
            getAllAuthorsStatement.setLong(1, bookId);
            ResultSet resultSet = getAllAuthorsStatement.executeQuery();
            List<Author> authors = new ArrayList<>();
            while (resultSet.next()) {
                authors.add(parseAuthorFromResultSet(resultSet));
            }
            return authors;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't find authors in DB by book id " + bookId, e);
        }
    }

    private Author parseAuthorFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String lastname = resultSet.getString("lastname");
        return new Author(id, name, lastname);
    }

    private Book parseBookWithLiteraryFormatFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setTitle(resultSet.getString("title"));
        resultSet.getString("title");
        book.setPrice(resultSet.getBigDecimal("price"));
        LiteraryFormat literaryFormat = new LiteraryFormat();
        literaryFormat.setId(resultSet.getObject("literary_format_id", Long.class));
        literaryFormat.setFormat(resultSet.getString("format"));
        book.setFormat(literaryFormat);
        book.setId(resultSet.getObject("book_id", Long.class));
        return book;
    }

    public void createSqlTables() {
        String createTableLiteraryFormatsQuery =
                "CREATE TABLE `literary_formats` ( "
                        + "  `format` varchar(255) DEFAULT NULL, "
                        + "  `id` bigint NOT NULL AUTO_INCREMENT, "
                        + "  `is_deleted` tinyint NOT NULL DEFAULT '0', "
                        + "  PRIMARY KEY (`id`)) ";
        String createTableBooksQuery =
                "CREATE TABLE `books` ( "
                        + "`id` bigint NOT NULL AUTO_INCREMENT, "
                        + "`title` varchar(255) NULL, "
                        + "`price` decimal(10,0) NULL, "
                        + "`is_deleted` tinyint NOT NULL DEFAULT '0', "
                        + "`literary_format_id` bigint NULL, "
                        + "PRIMARY KEY (`id`), "
                        + "CONSTRAINT `books_literary_formats_fk`  "
                        + "   FOREIGN KEY (`literary_format_id`)  "
                        + "   REFERENCES `librari_db`.`literary_formats` (`id`) "
                        + "            ON DELETE NO ACTION "
                        + "            ON UPDATE NO ACTION); ";
        String createTableBooksAuthorsQuery =
                "CREATE TABLE `books_authors`( "
                        + "`book_id` BIGINT NOT NULL, "
                        + "`author_id` BIGINT NOT NULL, "
                        + "CONSTRAINT `books_author_books_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`), "
                        + "CONSTRAINT `books_author_authors_fk` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`));";
        String createTableAuthorsQuery =
                "CREATE TABLE authors ( "
                        + "`id` BIGINT NOT NULL AUTO_INCREMENT, "
                        + "`name` VARCHAR(255) NULL, "
                        + "`lastname` VARCHAR(255) NULL, "
                        + "PRIMARY KEY (`id`));";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createTableLiteraryFormatsStatement = connection.prepareStatement(createTableLiteraryFormatsQuery);
             PreparedStatement createTableBooksStatement = connection.prepareStatement(createTableBooksQuery);
             PreparedStatement createTableBooksAuthorsStatement = connection.prepareStatement(createTableBooksAuthorsQuery);
             PreparedStatement createTableAuthorsStatement = connection.prepareStatement(createTableAuthorsQuery)) {
            createTableLiteraryFormatsStatement.executeQuery();
            createTableBooksStatement.executeQuery();
            createTableBooksAuthorsStatement.executeQuery();
            createTableAuthorsStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
