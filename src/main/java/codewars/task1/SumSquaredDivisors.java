package codewars.task1;
import java.util.ArrayList;
import java.util.List;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        List<long[]> result = new ArrayList<>();
        for (long num = m; num <= n; num++) {
          long sumOfSquares = 0;
            for (long i = 1; i <= num; i++) {
                if (num % i == 0) {
                    sumOfSquares += i * i;
                }
            }
            long squareRoot = (long) Math.sqrt(sumOfSquares);
            if (squareRoot * squareRoot == sumOfSquares) {
                result.add(new long[]{num, sumOfSquares});
            }
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < result.size(); i++) {
            sb.append("[")
                    .append(result.get(i)[0])
                    .append(", ")
                    .append(result.get(i)[1])
                    .append("]");
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(listSquared(1, 250));
        System.out.println(listSquared(42, 250));
    }
}