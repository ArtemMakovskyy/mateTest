package main.lambda.pred;

import java.util.function.Predicate;

public class UserPredivate implements Predicate<User> {
    @Override
    public boolean test(User user) {
      return   user.getAge() > 18 && user.getName().startsWith("V");
    }
}
