package main.java8.functional.interfaces;

import lombok.SneakyThrows;
import main.java8.functional.interfaces.f.i.StudentsGradeFunction;
import main.lambda.func_int.CheckedExseption;
import main.lambda.func_int.User;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class FIMain {
    public static void main(String[] args) {
        StudentsGradeFunction studentsGradeFunction = new StudentsGradeFunction();
        String apply = studentsGradeFunction.apply(25);

        User bob = new User("Bob",22);
        Function<User,String> userStringFunction = user -> user.getUser();
        System.out.println(userStringFunction.apply(bob));

        Supplier<Integer> random = ()-> new Random().nextInt();
        System.out.println(random.get());

        Function<String,String> stringFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                if (s == null){
                    throw new RuntimeException();
                }
                return s.toUpperCase();
            }
        };
    }

}
