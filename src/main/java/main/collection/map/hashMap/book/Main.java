package main.collection.map.hashMap.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        first();
        test();

    }
    public static void test() {
        Map<String, Number> numbers = new HashMap<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put(null, 4);
        System.out.println(numbers);
    }
    static void first(){
        GetAuthorByBook gab = new GetAuthorByBook();
        System.out.println(gab.getAuthorNameByBookTitle3(libraryHashMap(), "hello5"));
        System.out.println(gab.getAuthorNameByBookTitle3(libraryHashMap(), "hello6"));
        System.out.println(gab.getAuthorNameByBookTitle3(libraryHashMap(), "hello7"));
        System.out.println(gab.getAuthorNameByBookTitle3(libraryHashMap(), "hello8"));
    }
    public static Map<Author, List<Book>> libraryHashMap() {
        Author author1 = new Author("Artem", "Ukraine");
        Author author2 = new Author("Sasha", "Austria");
        Author author3 = new Author("Dima", "USA");
        Book book1 = new Book("hello1", 1979);
        Book book2 = new Book("hello2", 1980);
        Book book3 = new Book("hello3", 1981);
        Book book4 = new Book("hello4", 1982);
        Book book5 = new Book("hello5", 1979);
        Book book6 = new Book("hello6", 1980);
        Book book7 = new Book("hello7", 1980);

        List<Book> books1 = new ArrayList<>(List.of(book1, book3, book5));
        List<Book> books2 = new ArrayList<>(List.of(book2, book4, book6));
        List<Book> books3 = new ArrayList<>(List.of(book7));

        Map<Author, List<Book>> biblioteka = new HashMap<>();
        biblioteka.put(author1, books1);
        biblioteka.put(author2, books2);
        biblioteka.put(author3, books3);
        return biblioteka;
    }
}
