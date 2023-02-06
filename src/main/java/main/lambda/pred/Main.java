package main.lambda.pred;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Vova1", 22));
        userList.add(new User("Vova9", 17));
        userList.add(new User("Vova4", 18));
        userList.add(new User("0Vova1", 22));
        UserPredivate userPredivate = new UserPredivate();
        for (User user : userList)
            if (userPredivate.test(user))
                System.out.println(user.getName());
    }
}
