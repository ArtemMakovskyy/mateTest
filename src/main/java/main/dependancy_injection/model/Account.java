package main.dependancy_injection.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String login;
    private String password;

{
        System.out.println("Account constructor");
    }
}
