package live.coding;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == delta) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(i + " " +map);
//            int remainder = target - nums[i];
//            if (map.containsKey(remainder))
//                return new int[]{map.get(remainder), i};
//            else map.put(nums[i], i);
//        }
//        return new int[]{};


//        int[] result = new int[2];
//        boolean next = true;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j < nums.length; j++)
//                if (nums[i] + nums[j] == target) {
//                    if (i == j) continue;
//                    result[0] = i;
//                    result[1] = j;
//                    next = false;
//                    break;
//                }
//            if (!next) break;
//        }
//        return result;
    }
}
//                    System.out.println(i + "=i " + j + "=j; " + nums[i] + " + " + nums[j] + " = " + (nums[i] + nums[j]));