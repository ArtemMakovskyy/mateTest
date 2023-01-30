package main.collection.set;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<UserComparator>userComparator = new Comparator<UserComparator>() {
            @Override
            public int compare(UserComparator user1, UserComparator user2) {
                int namesCompared = user1.getName().compareTo(user2.getName());
                if (namesCompared != 0) {
                    return namesCompared;
                }
                return Integer.compare(user1.getAge(), user2.getAge());
            }
        };

        Set<UserComparator>usersComparatorList = new TreeSet<>(userComparator);
        usersComparatorList.add(new UserComparator("Bob",23));
        usersComparatorList.add(new UserComparator("Alic",24));
        usersComparatorList.add(new UserComparator("Jhon",25));
        usersComparatorList.add(new UserComparator("Bob",18));
        usersComparatorList.add(new UserComparator("Bob",82));
        for (UserComparator user : usersComparatorList)
            System.out.println(user);

    }


}
