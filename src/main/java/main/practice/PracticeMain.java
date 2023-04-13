package main.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeMain {
    public static void main(String[] args) {

        Client harry = new Client("Harry Carter", 15, true);
        Client ann = new Client("Ann Jackson", 15, true);
        List<Client> clients = List.of(harry, ann);
        clients.stream()
                .map(c -> c.getName().split(" ")[1])
                .forEach(System.out::println);



        clients.stream()
                .map(c -> c.getName().split(" "))
                .map(c -> c[1])
                .forEach(System.out::println);
    }
}
