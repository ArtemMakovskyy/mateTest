https://java-online.ru/sql-schema.xhtml

CREATE DATABASE taxi_service_db;
CREATE DATABASE taxi_service_db CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE SCHEMA IF NOT EXISTS `taxi_service_db` DEFAULT CHARACTER SET utf8;

DROP SCHEMA schema_name;
DROP SCHEMA IF EXISTS schema_name;
USE `taxi_service`;

CREATE TABLE authors (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NULL,
`lastname` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

INSERT INTO authors (name, lastname) VALUES ('Taras','SHEVCHENKO');
DELETE FROM authors where name = 'Olena' AND id = 3;
UPDATE authors SET name = 'Igor' WHERE id = 2;

CREATE TABLE `books` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NULL,
  `price` decimal(10,0) NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `literary_format_id` bigint NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `books_literary_formats_fk` FOREIGN KEY (`literary_format_id`) REFERENCES `librari_db`.`literary_formats` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION);

CREATE TABLE `books_authors`(
`book_id` BIGINT NOT NULL,
`author_id` BIGINT NOT NULL,
	CONSTRAINT `books_author_books_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
	CONSTRAINT `books_author_authors_fk` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`));


=====================================

CREATE SCHEMA IF NOT EXISTS `taxi_service2_db` DEFAULT CHARACTER SET utf8;
USE `taxi_service2_db`;
DROP TABLE IF EXISTS `manufacturers`;
CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE `drivers` (
                                  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                  `name` VARCHAR(225) NOT NULL,
                                  `license_number` VARCHAR(225) NOT NULL,
                                  `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                  PRIMARY KEY (`id`),
                                  UNIQUE INDEX `id_UNIQUE` (id ASC) VISIBLE,
                                  UNIQUE INDEX `license_number_UNIQUE` (`license_number` ASC) VISIBLE);

CREATE TABLE `car`(
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `model` VARCHAR(255) NOT NULL,
    `manufacturer_id` BIGINT(11) NOT NULL,
    `is_deleted` TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`));