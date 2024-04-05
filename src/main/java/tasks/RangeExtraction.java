package tasks;

public class RangeExtraction {
    public static String extractRange(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            sb.append(start);
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            if (j - i >= 3) {
                sb.append("-");
                sb.append(nums[j - 1]);
            } else {
                for (int k = i + 1; k < j; k++) {
                    sb.append(",");
                    sb.append(nums[k]);
                }
            }
            if (j != nums.length) {
                sb.append(",");
            }
            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = extractRange(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20});
        String s2 = extractRange(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20});
//        String s = extractRange(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20});
//        String s = extractRange(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20});
        System.out.println(s);
        System.out.println(s2);
    }
}