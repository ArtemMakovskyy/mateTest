import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        contrvariant();
        invariant();
    }
   static void contrvariant(){
        List<Number> nums = new ArrayList<Number>(25);
        List<? super Integer> ints = nums;
        ints.add(36);
        ints.get(0);
       System.out.println(ints);
    }
    static void invariant(){
        List<Integer> ints = new ArrayList<Integer>(25);
        List<? extends Number> nums = ints;
//        nums.add(36);  //it doesn't work
//        nums.get(0);
        System.out.println(nums);
    }
}
