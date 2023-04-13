package main.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Client {
    private String name;
    private int sum;
    private boolean isActive;
}
