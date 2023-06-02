package alhoritms;

import java.util.Arrays;
import java.util.Random;

public class BubblesSort {
    public static void main(String[] args) {
        int[] ints = bubbleSort(createArr());
        System.out.println(Arrays.toString(ints));
        Arrays.stream(ints).forEach(System.out::println);
    }

    static int[] bubbleSort(int[] arr) {
        while (true) {
            int count = 0;
            for (int i = 0; i < arr.length - 1; i++)
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    count++;
                }
            if (count == 0) return arr;
        }
    }

    static int[] createArr() {
        int[] arr = new int[(int) (Math.random() * 10_000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000) * (i % 3 == 0 ? -1 : 1);
        }
        return arr;
    }
}
