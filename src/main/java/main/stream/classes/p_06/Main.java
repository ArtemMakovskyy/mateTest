package main.stream.classes.p_06;

import main.stream.classes.p_06.db.Storage;
import main.stream.classes.p_06.model.Author;
import main.stream.classes.p_06.model.Book;
import main.stream.classes.p_06.model.User;
import main.stream.classes.p_06.service.AuthorService;
import main.stream.classes.p_06.service.AuthorServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static AuthorService authorService = new AuthorServiceImpl();

    public static void main(String[] args) {
//        main();
//        allVariants1(Storage.getStatistic());
//        allVariants2(Storage.getStatistic());
        allVariants3(Storage.getStatistic());
    }

    private static void allVariants1(Map<User, List<Book>> statistic) {
        Set<Map.Entry<User, List<Book>>> entries = statistic.entrySet();
        for (Map.Entry<User, List<Book>> user : entries){
            System.out.println("user.getKey() " + user.getKey());
            System.out.println("user.getValue() " + user.getValue());

        }

    }

    private static void allVariants2(Map<User, List<Book>> statistic) {
        Set<User> users = statistic.keySet();
        System.out.println(users);


    }

    private static void allVariants3(Map<User, List<Book>> statistic) {
        Collection<List<Book>> values = statistic.values();
       values.stream().forEach(System.out::println);

    }

    private static void main() {
        List<Author> storage = authorService.getMPByAA(25, 35);
        for (Author author : storage)
            System.out.println(author);
    }
}
