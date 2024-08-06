package live.coding.training;

import java.util.Arrays;
import live.coding.Solution1;
import live.coding.Solution2678;
import live.coding.Solution27;

public class Start {
    String[] passengers = new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"};
    static int[] intarr = new int[]{3,2,2,3};

    public static void main(String[] args) {
        Solution27 s = new Solution27();
        System.out.println(s.removeElement(intarr, 3));
    }
}
