package main.lambda.func_int;
import java.util.function.Function;

/*
function
predicate
consumer
supplier
...
 */
public class Main {
    public static void main(String[] args) {
        StudentsGradeFunction gradeFunction = new StudentsGradeFunction();
        String apply = gradeFunction.apply(50);
        System.out.println(apply);

       User bob = new User("Bob",22);
       Function<User,String>userStringFunction = User::getUser;
        System.out.println(userStringFunction.apply(bob));
    }
}
