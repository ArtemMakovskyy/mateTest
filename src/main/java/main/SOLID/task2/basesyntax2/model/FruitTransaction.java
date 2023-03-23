package main.SOLID.task2.basesyntax2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Setter
@Getter
@ToString
public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperation(String code) {
            return Arrays.stream(Operation.values())
                    .filter(c -> c.getCode().equals(code))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("Operation code '"
                            + code + "' doesn't exist"));
        }
    }
}