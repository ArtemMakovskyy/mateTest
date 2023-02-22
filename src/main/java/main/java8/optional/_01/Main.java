package main.java8.optional._01;

import lombok.*;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[]{new User("Bob",12)};
        Wrapper<User> userWrapper = getElementByIndex(users, 0);

        userWrapper.ifPresent(System.out::println);

    }

    private static Wrapper<User> getElementByIndex(User[] values, int index) {
        if (index >= values.length || index < 0) {
            return Wrapper.empty();
        }
        return new Wrapper<>(values[index]);
    }
}

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
class User {
    String name;
    int index;
}