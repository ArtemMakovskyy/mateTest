package live.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution136 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 1, 2, 4};
//        System.out.println(singleNumber(nums));

//        IntStream.range(0,11).forEach(n->System.out.println("1^" + n + " = " + (1^n)));

        test();
    }

    public static void test() {
        int a = 5;
        int b = 7;

        // Обмен значений с помощью XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a + ", b = " + b); // a = 7, b = 5
    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static int singleNumber5(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i = i + 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }


    public static int singleNumber4(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        for (int i = 1; i < nums.length; i = i + 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> resultsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            resultsMap.put(nums[i], resultsMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int num : nums) {
            if (resultsMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static int singleNumber3(int[] nums) {
        int result = 0;
        int[] count = new int[10];
        int[] countMinus = new int[10];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int numberMinus = nums[i] * -1;
                if (countMinus[numberMinus] == 0) {
                    countMinus[numberMinus] = 1;
                } else {
                    countMinus[numberMinus]++;
                }
            } else if (count[nums[i]] == 0) {
                count[nums[i]] = 1;
            } else {
                count[nums[i]]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                result = i;
                break;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (countMinus[i] == 1) {
                result = i * -1;
                break;
            }
        }
        return result;
    }
}
