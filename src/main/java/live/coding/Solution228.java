package live.coding;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges2(nums1));

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums2));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1] -1 ){
                continue;
            }

        }

        return result;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start == nums[i]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i]);
                }

                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return result;
    }
}
