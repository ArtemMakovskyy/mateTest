package tasks;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int findMajor(int[] nums) {
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (results.containsKey(nums[i])) {
                results.put(nums[i], results.get(nums[i]) + 1);
            } else {
                results.put(nums[i], 1);
            }
        }
        int keyWithMaxValue = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                keyWithMaxValue = entry.getKey();
            }
        }
        return keyWithMaxValue;
    }

    public static void main(String[] args) {
        System.out.println(findMajor(new int[]{-6, -2, -6, -6, -2, -6, -2, -2, -6}));
    }
}