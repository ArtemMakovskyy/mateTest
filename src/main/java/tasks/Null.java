package tasks;

public class Null {
    public boolean equals(Object obj) {
        return obj == null || obj instanceof Null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "null";
    }
}