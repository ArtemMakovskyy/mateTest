package live.coding;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java1 {
    private final static int[] NUMS = new int[]{1, 3, 8, 5, 5, 1, 2, 9, 78, 6, 85};
    private final static String TEXT = "HEllo world";


    public static void main(String[] args) {
//        findMin(NUMS);
//        reverse(TEXT);
//        showNumbersWichDevBy3BytNodDevBy5();
//        removeextracharacters();

    }

    private static void removeextracharacters() {
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
                //var 1
        if (false) {
            streamOfArray.map(s -> s.split("")) //Преобразование слова в массив букв
                    .flatMap(Arrays::stream).distinct() //выравнивает каждый сгенерированный поток в один поток
                    .collect(Collectors.toList()).forEach(System.out::println);
        }
        if (true) {
            streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
                    .map(Arrays::stream).distinct() //Сделать массив в отдельный поток
                    .collect(Collectors.toList()).forEach(System.out::println);
        }
    }


    private static void showNumbersWichDevBy3BytNodDevBy5() {

        for (int i = 0; i < 1000; i++) {
            //var 1
            if (false) {
                if (i % 3 == 0 && i % 5 != 0 && testSumNumbers(i) < 10) {
                    System.out.println(i + " " + (testSumNumbers(i) < 10));
                }
            }
            //var 2
            if (true) {
                if (i % 3 != 0) continue;
                if (i % 5 == 0) continue;
                if (testSumNumbers(i) > 10) continue;
                System.out.println(i);
            }
        }
    }

    public static int testSumNumbers(int number) {
        int sum = 0;
        //option 1
        if (false) {
            final String stringNumber = Integer.toString(number);
            final char[] charArray = stringNumber.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                sum += Integer.parseInt(stringNumber.substring(i, i + 1));
            }
        }
        //option 2
        if (true) {
            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
        }
        return sum;
    }


    private static String reverse(String text) {
        StringBuilder sb = new StringBuilder(text);
        final String string = sb.reverse().toString();
        System.out.println(string);
        return string;
    }

    private static int findMin(int[] nums) {
        int maxNumber = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxNumber < nums[i]) {
                maxNumber = nums[i];
            }
        }
        System.out.println("maxNumber: " + maxNumber);

        return Arrays.stream(nums).max().getAsInt();
    }
}
