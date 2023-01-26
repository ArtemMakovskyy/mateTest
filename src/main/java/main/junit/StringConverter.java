package main.junit;

public class StringConverter {

    public String toUpperCase(String inputString) {
        StringBuilder builder = new StringBuilder();
        for (char symbol : inputString.toCharArray()) {
            builder.append(Character.toUpperCase(symbol));
        }
        return builder.toString();
    }
}