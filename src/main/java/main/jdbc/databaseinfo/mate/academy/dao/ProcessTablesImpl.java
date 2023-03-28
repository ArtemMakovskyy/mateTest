package main.jdbc.databaseinfo.mate.academy.dao;

import main.jdbc.databaseinfo.mate.academy.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessTablesImpl implements ProcessTables {
    @Override
    public void literary_formats() {
        String createTableLiteraryFormatsQuery =
                "CREATE TABLE `literary_formats` ( "
                        + "  `format` varchar(255) DEFAULT NULL, "
                        + "  `id` bigint NOT NULL AUTO_INCREMENT, "
                        + "  `is_deleted` tinyint NOT NULL DEFAULT '0', "
                        + "  PRIMARY KEY (`id`)) ";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createTableLiteraryFormatsStatement = connection.prepareStatement(createTableLiteraryFormatsQuery); ) {
            createTableLiteraryFormatsStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void authors() {
        String createTableAuthorsQuery =
                "CREATE TABLE authors ( "
                        + "`id` BIGINT NOT NULL AUTO_INCREMENT, "
                        + "`name` VARCHAR(255) NULL, "
                        + "`lastname` VARCHAR(255) NULL, "
                        + "PRIMARY KEY (`id`));";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createTableAuthorsStatement = connection.prepareStatement(createTableAuthorsQuery)) {
            createTableAuthorsStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void books() {
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
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createTableBooksStatement = connection.prepareStatement(createTableBooksQuery)) {
            createTableBooksStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void books_authors() {
        String createTableBooksAuthorsQuery =
                "CREATE TABLE `books_authors`( "
                        + "`book_id` BIGINT NOT NULL, "
                        + "`author_id` BIGINT NOT NULL, "
                        + "CONSTRAINT `books_author_books_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`), "
                        + "CONSTRAINT `books_author_authors_fk` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`));";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createTableBooksAuthorsStatement = connection.prepareStatement(createTableBooksAuthorsQuery)) {
            createTableBooksAuthorsStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
