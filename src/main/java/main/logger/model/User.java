package main.logger.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String serName;
    private int age;
    private Login login;

    public User(String name) {
        this.name = name;
    }
}
