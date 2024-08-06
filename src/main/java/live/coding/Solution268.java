package live.coding;

public class Solution268 {
    private String link = "https://leetcode.com/problems/missing-number/";
    private String desc = "268. Missing Number";
    private String desc2 = "Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.";

    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int result = findMissingNumber(nums);
        result = findMissingNumber2(nums);
        return result;
    }

    private static int findMissingNumber2(int[] nums) {
        boolean[] position = new boolean[nums.length + 1];
        for (int num : nums) {
            position[num] = true;
        }
        int missingNumber = -1;
        for (int i = 0; i < position.length; i++) {
            if (!position[i]) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }

    private static int findMissingNumber(int[] nums) {
        nums = sort(nums);
        int missingNumber = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                missingNumber = nums[i] - 1;
                break;
            }
        }

        if (missingNumber == -1) {
            if (nums[0] != 0) {
                return missingNumber = 0;
            }
            missingNumber = nums.length;
        }
        return missingNumber;
    }

    private static int[] sort(int[] arr) {
        boolean sort = true;
        while (sort) {
            sort = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    sort = true;
                }
            }
        }
        return arr;
    }
}
