package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TheLargestNumber {
    public long getMaxNumber(long num) {
        String temp = Long.toString(num);
        char[] charArr = temp.toCharArray();
        Arrays.sort(charArr);

        StringBuilder result = new StringBuilder();
        for (int count = 0; count != charArr.length; count++) {
            result.append(charArr[charArr.length - count - 1]);
        }

        return Long.parseLong(result.toString());
    }
}
