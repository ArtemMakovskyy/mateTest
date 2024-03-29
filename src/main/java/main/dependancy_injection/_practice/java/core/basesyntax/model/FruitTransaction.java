package main.dependancy_injection._practice.java.core.basesyntax.model;

import java.util.Arrays;
import java.util.Objects;
public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitTransaction)) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return getQuantity() == that.getQuantity() && getOperation() == that.getOperation()
                && Objects.equals(getFruit(), that.getFruit());
    }

    @Override
    public String toString() {
        return
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation(), getFruit(), getQuantity());
    }

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

        public static Operation getByCode(String code) {
            return Arrays.stream(Operation.values())
                    .filter(s -> s.getCode().equals(code))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("Operation code '"
                            + code + "' doesn't exist"));
        }
    }
}
