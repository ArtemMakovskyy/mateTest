package main.java8.optional._03OpOr;

import main.java8.stream.classes.p_07.model.User;

import java.util.Optional;

public class DataBase {
    public Optional<User> getById(Long id) {
        if (id == 10)
            return Optional.of(new User("Bob", "123"));
        return Optional.empty();
    }
}
