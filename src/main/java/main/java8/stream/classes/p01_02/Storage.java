package main.java8.stream.classes.p01_02;

import lombok.*;
import main.java8.stream.classes.model.UserName;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Storage {
    List<UserName> users = new ArrayList<>();

    {
        users.add(new UserName("Bob"));
        users.add(new UserName("Alice"));
        users.add(new UserName("John"));
        users.add(new UserName("Bruce"));
    }

}
