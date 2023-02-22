package main.java8.stream.classes.p01_02;

import main.java8.stream.classes.model.UserName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainStream_01 {
    static List<UserName> users = new ArrayList<>();

    static {
        Storage storage = new Storage();
        users.addAll(storage.users);
    }

    public static void main(String[] args) {
//var1
        for (UserName user : users)
            if (user.getName().startsWith("B"))
                System.out.println(user.getName());
        System.out.println();
//var2
        Predicate<UserName> userNamePredicate = (userName) -> userName.getName().startsWith("B");
        for (UserName user : users)
            if (userNamePredicate.test(user))
                System.out.println(user.getName());
        System.out.println();
//var3
        users.stream()
                .filter(userNamePredicate)
                .forEach(user -> System.out.println(user.getName()));
        System.out.println();
//var4
        users.stream()
                .filter((userName) -> userName.getName().startsWith("B"))
                .forEach(user -> System.out.println(user.getName()));
    }
}
