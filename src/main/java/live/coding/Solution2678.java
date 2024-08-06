package live.coding;

import java.util.Arrays;

public class Solution2678 {
    private final static int YEAR = 60;

    public int countSeniors(String[] details) {
        int counter = 0;
        for (String passenger : details) {
            System.out.println(passenger.substring(11, 13));
            int ear = Integer.parseInt(passenger.substring(11, 13));
            if (ear > YEAR) counter++;
        }
        return counter;
    }

    public int countSeniors2(String[] details) {
        return (int) Arrays.stream(details)
                .map(y -> y.substring(11, 13))
                .mapToInt(Integer::parseInt)
                .filter(y -> y > 60)
                .count();
    }
}