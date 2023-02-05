package main.lambda.ref;

import java.nio.file.Path;
import java.util.Arrays;

/* Method reference
There are four kinds
    -static
    -instance method of particular objects
    -instance method of arbitrary objects of a particular type
    -constructor
 */
public class ReferenceMethod {
    public static void main(String[] args) {
        Path path = Path.of("https://www.youtube.com/watch?v=oHwCnTAE_wg&t=359s");
//        -static
        NumbersService<Integer> static_integerNumbersService = Integer::parseInt;
        System.out.println(static_integerNumbersService.getFormString("123"));

//        -instance method of particular objects
        User[] people = new User[3];
        people[0] = new User("Bob");
        people[1] = new User("Alice");
        people[2] = new User("John");
        ComparisonProvider comparisonProvider = new ComparisonProvider();
        Arrays.sort(people, comparisonProvider::compareByName);
        System.out.println(Arrays.toString(people));

//       -instance method of arbitrary objects of a particular type
        String[] names = {"barbara", "Barbara1", "Barbar2", "barba3ra3"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

//        -constructor
        UserService userService = User::new;
        User bob = userService.of("Bob");
        System.out.println(bob);
    }
}
