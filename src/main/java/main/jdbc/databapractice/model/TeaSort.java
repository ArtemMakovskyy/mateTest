package main.jdbc.databapractice.model;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class TeaSort {
    private Long id;
    private String name;
    private double price;

    public TeaSort(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
