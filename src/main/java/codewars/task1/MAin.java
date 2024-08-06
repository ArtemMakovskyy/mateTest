package codewars.task1;

public class MAin {

}

class Kata1 {
    String str = "";

    public static void main(String[] args) {
        System.out.println(squareSum(new int[]{1, 2, 2,}));
    }

    public static int squareSum(int[] n) {
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            result +=  n[i] * n[i];
        }
        return result;
    }

    public static String countingSheep(int num) {
        String sheep = " sheep...";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            sb.append(i).append(sheep);
        }
        return sb.toString();
    }
}