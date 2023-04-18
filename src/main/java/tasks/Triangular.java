package tasks;

public class Triangular {
    int counter = 0;

    public int getTriangular(int n) {
        for (int i = 1; i <= n; i++) {
            counter += i;
        }
        return counter;
    }
}
