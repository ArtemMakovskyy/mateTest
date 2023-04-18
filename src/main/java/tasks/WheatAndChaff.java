package tasks;

import java.util.Arrays;

public class WheatAndChaff {
    public long[] separateWheatFromChaff(long[] nums) {
        if (nums == new long[]{}) {
            return new long[]{};
        }
        int reverseSlot = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= reverseSlot) {
                break;
            }
            if (nums[i] < 0 && nums[reverseSlot] < 0) {
                continue;
            }
            if (nums[i] > 0 && nums[reverseSlot] < 0) {
                long tempReverseSlot = nums[reverseSlot];
                nums[reverseSlot] = nums[i];
                nums[i] = tempReverseSlot;
                reverseSlot--;
            }
            if (nums[i] > 0 && nums[reverseSlot] > 0) {
                reverseSlot--;
                i--;
                continue;
            }
        }
        return nums;
    }
}
