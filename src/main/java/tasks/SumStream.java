package tasks;

import java.util.List;

public class SumStream {
    public static int sumStream(List<Integer> list) {
        // write code here
        return list.stream().filter(n -> n > 10).reduce(0, (t, n) -> t + n);
    }
}