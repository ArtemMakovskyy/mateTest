package main.stream.classes.p_06.db;

import main.stream.classes.p_06.model.Author;
import main.stream.classes.p_06.model.Book;
import main.stream.classes.p_06.model.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static Map<User, List<Book>> getStatistic() {
        User bob = new User("Bob", 23);
        User alice = new User("Alice", 27);
        User john = new User("John", 32);
        User bill = new User("Bill", 29);

        Author miguelDeCerrvantes = new Author("Miguel", "de Corvantes");
        Book donQuixote = new Book("Don Quixote", miguelDeCerrvantes);
        Book ispaniolaIglessa = new Book("Ispaniola Iglessa", miguelDeCerrvantes);

        Author markTwain = new Author("Mark", "Twain");
        Book tomSoyer = new Book("The Adventires of Tom Soyer", markTwain);


        Book thinkin = new Book("Thinkin in java", new Author("Bruce", "Ekkrl"));
        Book thinkinC = new Book("Thinkin in java", new Author("Bruce", "Ekkrl"));
        Book javaEi = new Book("On java 8", new Author("Bruce", "Ekkrl"));

        Map<User, List<Book>> statistic = new HashMap<>();
        statistic.put(bob, List.of(donQuixote, ispaniolaIglessa));
        statistic.put(alice, List.of(tomSoyer));
        statistic.put(john, Collections.emptyList());
        statistic.put(bill, List.of(thinkin, thinkinC, javaEi));
        return statistic;
    }
}
