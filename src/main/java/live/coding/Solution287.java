package live.coding;

import java.util.Arrays;

public class Solution287 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(a));
        int[] b = new int[]{3, 1, 3, 4, 2};
        System.out.println(findDuplicate(b));
        int[] c = new int[]{3, 3, 3, 3, 3};
        System.out.println(findDuplicate(c));
        int[] d = new int[]{3, 2, 5, 14, 5, 5, 19, 18, 11, 10, 1, 4, 5, 5, 5, 5, 12, 5, 17, 5};
        System.out.println(findDuplicate(d));
    }

    public static int findDuplicate(int[] nums) {
        boolean contains[] = new boolean[nums.length];
        for (int num : nums) {
            if (contains[num]) {
                return num;
            }
            contains[num] = true;
        }
        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        boolean[] contains = new boolean[nums.length];
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!contains[nums[i]]) {
                contains[nums[i]] = true;
            } else {
                result = nums[i];

            }
        }
        return result;
    }
}
