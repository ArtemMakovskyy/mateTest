package main.immutable.listdeep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob", 22);
        User alice = new User("Alice", 23);

        List<User> users = new ArrayList<>();
        users.add(bob);
        users.add(alice);

        List<User> userCopy = getCopy(users);
        System.out.println(userCopy);
        users.get(0).setAge(32);
        System.out.println("users "+users);
        System.out.println(userCopy);


    }

    private static List<User> getCopy(List<User> users) {
        List<User> userCopyInGetCopy = new ArrayList<>(users.size());
        for (User user : users){
            userCopyInGetCopy.add(user.clone());
        }
        // poverhnostnoe
//        return new ArrayList<>(users);
        return userCopyInGetCopy;
    }
}
