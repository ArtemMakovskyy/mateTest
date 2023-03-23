package main.jdbc.databaseinfo.mate.academy.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Author {
    private Long id;
    private String name;
    private String lastName;
}
