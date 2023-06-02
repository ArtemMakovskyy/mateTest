package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(isDisarium(135));
    }

    public static boolean isDisarium(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = (int) Math.pow(Integer.parseInt(String.valueOf(chars[i])), i + 1);
        }
        return number == Arrays.stream(nums).sum();
    }

    public static String sortGiftCode(String code) {
        char[] chars = code.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static String play(String player1, String player2) {
        String paper = "paper";
        String scissors = "scissors";
        String rock = "rock";
        if (player1.equals(player2)) {
            return "Draw!";
        } else if (player1 == paper) {
            if (player2 == scissors) {
                return "Player 2 won!";
            }
            if (player2 == rock) {
                return "Player 1 won!";
            }
        } else if (player1 == scissors) {
            if (player2 == paper) {
                return "Player 1 won!";
            }
            if (player2 == rock) {
                return "Player 2 won!";
            }
        } else if (player1 == rock) {
            if (player2 == scissors) {
                return "Player 1 won!";
            }
            if (player2 == paper) {
                return "Player 2 won!";
            }
        }
        return "";
    }

    public static String[] capitalizeNames(String[] names) {
        String[] newNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = String.valueOf(names[i].charAt(0)).toUpperCase() + names[i].substring(1, names[i].length()).toLowerCase();
        }
        return newNames;
    }

    public static int getSumOfElements(int[][] matrix) {
        return Arrays.stream(matrix).flatMapToInt(i -> Arrays.stream(i)).sum();
    }

//    public static String highAndLow(String numbers) {
//        int[] ints = Arrays.stream(numbers.split(" "))
//                .mapToInt(d -> Integer.parseInt(d))
//                .toArray();
//        return Arrays.stream(ints).max().getAsInt() + " " + Arrays.stream(ints).min().getAsInt();
//    }
//
//    public static String countSheep(int number) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < number; i++) {
//            sb.append(i + 1).append(" ").append("sheep...");
//        }
//        return sb.toString();
//    }
//
//    public static int findShortest(String string) {
//        String[] s = string.split(" ");
//        int min = s[0].length();
//        for (int i = 1; i < s.length; i++) {
//            if (s[i].length() < min) {
//                min = s[i].length();
//            }
//        }
//        return min;
//    }
//
//    public static boolean isTheSameAmountOfXO(String string) {
//        string = string.toLowerCase();
//        return string.replace("o", "").length() == string.replace("x", "").length();
//    }
}
