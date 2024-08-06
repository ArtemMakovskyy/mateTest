package live.coding;

import java.util.Arrays;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        Arrays.stream(nums).forEach(System.out::println);
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println();
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println();
        return k;




//        boolean[] deletedIndex = new boolean[nums.length];
//        int c = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                c++;
//                deletedIndex[i] = true;
//            }
//        }
//        int[] d = new int[nums.length - c];
//        int a = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (deletedIndex[i]) {
//                a--;
//                continue;
//            }
//            d[i + a] = nums[i];
//        }
//        nums = d;
//        return c;
    }
}