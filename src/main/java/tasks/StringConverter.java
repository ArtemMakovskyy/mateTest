package tasks;

public class StringConverter {
    public String stringify(int size) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            if (i % 2 == 0) {
                result.append("0");
            }else {
                result.append("1");
            }
        }
        return result.toString();
    }
}
