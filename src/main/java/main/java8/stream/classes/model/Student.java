package main.java8.stream.classes.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String name;
    private char sex;
    int age, course;
    double averageGrade;
}
