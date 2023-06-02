package tasks;

import java.util.Arrays;

public class MaxRotate {
    public long getMaxRotations(long number) {
        long[] arr = new long[5];
        arr[0] = number;
        String firstRotation = String.valueOf(arr[0]);
        arr[1] =  Long.valueOf(firstRotation.substring(1) + firstRotation.charAt(0));
        String secondRotation = String.valueOf(arr[1]);
        arr[2] =  Long.valueOf(String.valueOf(secondRotation.charAt(0))
                + secondRotation.substring(2)
                + secondRotation.substring(1, 2));
        String thirdRotation = String.valueOf(arr[2]);
        arr[3] =  Long.valueOf(thirdRotation.substring(0, 2)
                + thirdRotation.substring(3)
                + thirdRotation.charAt(2));
        String fourthRotation = String.valueOf(arr[3]);
        arr[4] =  Long.valueOf(fourthRotation.substring(0, 3)
                + fourthRotation.substring(4)
                + fourthRotation.charAt(3));
        return Arrays.stream(arr).max().getAsLong();

    }
}