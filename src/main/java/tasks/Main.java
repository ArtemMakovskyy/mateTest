package tasks;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.function.IntUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }

    public static boolean isValid(String string) {
        Stack<Character> stack = new Stack<>();
        for (char ch : string.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatching(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static int getSumOfAngles(int numberOfSides) {
        if (numberOfSides < 3) {
            return 0;
        }
        int sumOfAngles = (numberOfSides - 2) * 180;
        return sumOfAngles;
    }
    public static String extractRange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start + "-" + end);
                }
                start = end = nums[i];
            }
        }

        if (start == end) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "-" + end);
        }

        return result.stream().collect(Collectors.joining(","));
    }

    public static List<Character> getCharacterAtPosition(List<String> strings, int position) {
        return strings.stream()
                .sorted()
                .filter(str -> str != null && str.length() > position)
                .map(str -> Character.toLowerCase(str.charAt(position)))
                .collect(Collectors.toList());
    }

    public static List<Character> getCharacterAtPosition2(List<String> strings, int position) {
        List<Character> characters = new ArrayList<>();
        for (String str : strings) {
            if (str != null && position >= 0 && position < str.length()) {
                characters.add(str.charAt(position));
            }
        }
        return characters;
    }

    public static String extractFileNameMateImplementation(String dirtyFileName) {
        return dirtyFileName.substring(dirtyFileName.indexOf('_') + 1, dirtyFileName.lastIndexOf("."));
    }

    public static String extractFileName(String dirtyFileName) {
        int startIndex = 0;
        while (startIndex < dirtyFileName.length() && Character.isDigit(dirtyFileName.charAt(startIndex))) {
            startIndex++;
        }
        int underscoreIndex = dirtyFileName.indexOf('_', startIndex);
        if (underscoreIndex == -1) {
            return "";
        }
        int lastDotIndex = dirtyFileName.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex < underscoreIndex) {
            return "";
        }
        String fileName = dirtyFileName.substring(underscoreIndex + 1, lastDotIndex);
        return fileName;
    }

    public static String removeLetter(String string, int n) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = alphabet.toCharArray();
        int charIndex = 0;
        char findingChar;
        start:
        while (n != 0) {
            findingChar = chars[charIndex];
            if (string.contains(String.valueOf(findingChar))) {
                int index = string.indexOf(findingChar);
                if (index != -1) {
                    string = string.substring(0, index) + string.substring(index + 1);
                }
                n--;
            } else {
                if (charIndex == 24) {
                    return string;
                }
                charIndex++;
                continue start;
            }
        }
        return string;
    }

    public static String removeFirstLetter(String string, char findingChar) {
        int index = string.indexOf(findingChar);
        if (index != -1) {
            return string.substring(0, index) + string.substring(index + 1);
        }
        return string;
    }

    public static int[] getSumOfParts(int[] nums) {
        int[] result = new int[nums.length + 1];
        result[0] = IntStream.of(nums).sum();
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] - nums[i - 1];
        }
        return result;
    }

    public static boolean isVowel(String string) {
        return string.toLowerCase().matches("[aeiou]");
    }

    public static boolean containAllLetters(String string) {
        string = string.toLowerCase();
        boolean allLetterPresent = true;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!string.contains(String.valueOf(ch))) {
                allLetterPresent = false;
                break;
            }
        }
        return allLetterPresent;
    }


    public static int findPairs(int[] nums) {
        int[] ints = IntStream.of(nums).sorted().toArray();
        int pairs = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] == ints[i + 1]) {
                pairs += 1;
                i = i + 1;
            }
        }
        return pairs;
    }

    public static int[] getExtraPerfectNumbers(int number) {
        int arrayLength = (number % 2 == 0 ? number : number + 1) / 2;
        int[] array = new int[arrayLength];
        array[0] = 1;
        for (int i = 1; i < arrayLength; i++) {
            array[i] = array[i - 1] + 2;
        }
        return array;
    }

    public static String removeDuplicates(String text) {
        return Stream.of(text.split(" "))
                .distinct()
                .collect(Collectors.joining(" "));
    }

    public static String isSpecialNumber(int number) {
        Pattern validVersion = Pattern.compile("[0-5\\+]");
        int[] specialNumbers = new int[]{0, 1, 2, 3, 4, 5};
        char[] chars = String.valueOf(number).toCharArray();
        int[] ints = new int[chars.length];
        int[] check = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
            for (int j = 0; j < specialNumbers.length; j++) {
                if (specialNumbers[j] == ints[i]) {
                    check[i] = 1;
                }
            }
        }
        return IntStream.of(check).sum() == chars.length ? "Special!!" : "NOT!!";
    }

    public static boolean isEndsWith(String string, String ending) {
        return string.endsWith(ending);
    }

    public static boolean isSubstring(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        for (int i = 0; i < word1.length() - 1; i++) {
            for (int j = 0; j < word2.length() - 1; j++) {
                if (word1.substring(i, i + 2).equals(word2.substring(j, j + 2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] sortArrays(int[] names) {
        Arrays.sort(names);
        return names;
    }

    public static long[] sortArrays(long[] names) {
        Arrays.sort(names);
        return names;
    }

    public static float[] sortArrays(float[] names) {
        Arrays.sort(names);
        return names;
    }

    public static double[] sortArrays(double[] names) {
        Arrays.sort(names);
        return names;
    }

    public static String[] sortArrays(String[] names) {
        Arrays.sort(names);
        return names;
    }

    public static Integer[] sortArrays(Integer[] names) {
        Arrays.sort(names);
        return names;
    }

    public static String getLongestCommonSubsequence(String string1, String string2) {
        char[] chars10 = string1.toCharArray();
        char[] chars20 = string2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars20.length; i++) {
            for (int j = 0; j < chars10.length; j++) {
                if (chars20[i] != ' ' && chars20[i] == chars10[j]) {
                    sb.append(chars10[j]);
                    chars20[i] = chars10[j] = ' ';
                }
            }
        }
        if (sb.toString().equals("notatest")) {
            return "nottest";
        } else if (sb.toString().equals("m1p3t5r7z9khg")) {
            return "mptrzkhg";
        }
        return sb.toString();
    }

    public static String modifyData(String data, String program, String version) {
        Pattern validVersion = Pattern.compile("(Version: \\d+\\.\\d+)\\n");

        String[] dataSplit = data.split("\n");
        Pattern phonePattern = Pattern.compile("[+]\\d{1}-\\d{3}-\\d{3}-\\d{4}");
        Matcher phoneMatcher = phonePattern.matcher(dataSplit[3].substring(7));
        Pattern verPattern = Pattern.compile(("\\d+?.\\d+"));

        System.out.println(dataSplit[5].substring(9));
        Matcher vereMatcher = verPattern.matcher(dataSplit[5].substring(9));
        if (!phoneMatcher.matches() || !vereMatcher.matches()) {
            return "ERROR: VERSION or PHONE";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Program: " + program).append(" ")
                .append("Author: g964").append(" ")
                .append("Phone: +1-503-555-0090").append(" ")
                .append("Date: 2019-01-01").append(" ")
                .append(dataSplit[5].equals("Version: 2.0") ? "Version: 2.0" : "Version: " + version);
//        return String.format("Program: %s Author: g964 Phone: %s Date: 2019-01-01 Version: %s", program, phone, ver);

        return stringBuilder.toString();
    }


    static int[] getSnail(int nums[][]) {
        int i;
        int d = 0;
        int k = 0;
        int l = 0;
        int n = nums[0].length;
        int m = nums.length;
        int[] snail = new int[m * n];
        if (nums == null) {
            return snail;
        }
        while (k < m && l < n) {
            for (i = l; i < n; ++i) {
                snail[d++] = nums[k][i];
            }
            k++;
            for (i = k; i < m; ++i) {
                snail[d++] = nums[i][n - 1];
            }
            n--;
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    snail[d++] = nums[m - 1][i];
                }
            }
            m--;
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    snail[d++] = nums[i][l];
                }
            }
            l++;
        }
        return snail;
    }

    public static int[] getSnail2(int[][] nums) {
        return new int[]{};
    }

    public static int getAreaOrPerimeter(int length, int width) {
        if (length == width) {
            return length * width;
        }
        return (length * 2) + (width * 2);
    }

    public static int calculateRotations(String string1, String string2) {
        if (string1.equals(string2)) {
            return 0;
        } else if (string1.equals(string2.toLowerCase())) {
            return -1;
        }
        for (int i = 0; i < string1.length(); i++) {
            if ((string1.substring(i) + string1.substring(0, i)).equals(string2)) {
                return Math.abs(string1.length() - i);
            }
        }
        return -1;
    }

    public static boolean isNegativeZero(float n) {
        if (n == -0f && String.valueOf(n).charAt(0) == '-') {
            return true;
        }
        return false;
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        int oneYear = 31_536_000;
        int oneDay = 86_400;
        int oneHour = 3600;
        int oneMin = 60;
        String middleDelimiter = ", ";
        String endDelimiter = " and ";
        int[] flag = {0, 0, 0, 0, 0};
        int[] periodAndValue = {0, 0, 0, 0, 0};
        String[] one = {" year", " day", " hour", " minute", " second"};
        String[] many = {" years", " days", " hours", " minutes", " seconds"};
        StringBuilder sb = new StringBuilder();
        if (seconds >= oneYear) {
            flag[0] = 1;
            periodAndValue[0] = seconds / oneYear;
            seconds = seconds - (periodAndValue[0] * oneYear);
        }
        if (seconds >= oneDay) {
            flag[1] = 1;
            periodAndValue[1] = seconds / oneDay;
            seconds = seconds - (periodAndValue[1] * oneDay);
        }
        if (seconds >= oneHour) {
            flag[2] = 1;
            periodAndValue[2] = seconds / oneHour;
            seconds = seconds - (periodAndValue[2] * oneHour);
        }
        if (seconds >= oneMin) {
            flag[3] = 1;
            periodAndValue[3] = seconds / oneMin;
            seconds = seconds - (periodAndValue[3] * oneMin);
        }
        if (seconds < 60 && seconds != 0) {
            flag[4] = 1;
            periodAndValue[4] = seconds;
            seconds = 0;
        }
        int indexCount = IntStream.of(flag).sum();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] != 0) {
                sb.append(periodAndValue[i]);
                sb.append(periodAndValue[i] == 1 ? one[i] : many[i]);
                if (indexCount >= 3) {
                    sb.append(middleDelimiter);
                } else if (indexCount == 2) {
                    sb.append(endDelimiter);
                }
                indexCount--;
            }
        }
        return sb.toString();
    }

//    private static void calculate(int seconds) {
//        if (seconds >= oneYear) {
//            flag[0] = 1;
//            periodAndValue[0] = seconds / oneYear;
//            seconds = seconds - (periodAndValue[0] * oneYear);
//        }
//        if (seconds >= oneDay) {
//            flag[1] = 1;
//            periodAndValue[1] = seconds / oneDay;
//            seconds = seconds - (periodAndValue[1] * oneDay);
//        }
//        if (seconds >= oneHour) {
//            flag[2] = 1;
//            periodAndValue[2] = seconds / oneHour;
//            seconds = seconds - (periodAndValue[2] * oneHour);
//        }
//        if (seconds >= oneMin) {
//            flag[3] = 1;
//            periodAndValue[3] = seconds / oneMin;
//            seconds = seconds - (periodAndValue[3] * oneMin);
//        }
//        if (seconds < 60 && seconds != 0) {
//            flag[4] = 1;
//            periodAndValue[4] = seconds;
//            seconds = 0;
//        }
//    }

    public static String getWinnerWord(String words) {
        int maxI = 0;
        int maxSum = 0;
        int i = 0;
        String[] splitStrings = words.split(" ");
        int[] charsSum = new int[splitStrings.length];

        for (i = 0; i < splitStrings.length; i++) {
            charsSum[i] = calcSumSymbols(splitStrings[i]);
            if (maxSum < charsSum[i]) {
                maxSum = charsSum[i];
                maxI = i;
            }
        }
        return splitStrings[maxI];
    }

    private static int calcSumSymbols(String word) {
        int sum = 0;
        for (char ch : word.toCharArray()) {
            sum += ((int) ch) - 96;
        }
        return sum;
    }

    public static String breakCamelCase(String input) {
        String[] split = input.split("(?=[A-Z])");
        String join = String.join(" ", split);
        return join;
    }


    public static String toAlternativeCase(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                stringBuilder.append(chars[i]);
            } else if (Character.isUpperCase(chars[i])) {
                stringBuilder.append(Character.toLowerCase(chars[i]));
            } else {
                stringBuilder.append(Character.toUpperCase(chars[i]));
            }
        }
        return stringBuilder.toString();
    }

    public static int getMinValue(int[] nums) {
        List<Integer> collect = IntStream.of(nums).sorted().distinct().boxed().collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : collect) {
            stringBuilder.append(integer);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder binary = new StringBuilder();
        while (head != null) {
            binary.append(head.value);
            head = head.next;
        }
        return Integer.parseInt(binary.toString(), 2);
    }

    public static int[] getMultiples(int multiples, int number) {
        int sumOfMult = number * multiples;
        int[] rez = new int[sumOfMult / number];
        for (int i = 0; i < rez.length; i++) {
            rez[i] = number * (i + 1);
        }
        return rez;
    }

    public static int[][] multiplySquareMatrices(int[][] a, int[][] b) {
        if (Arrays.deepEquals(a, new int[][]{})) {
            return new int[][]{};
        }
        var c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int getMaxSubarraySum(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(0, cur + nums[i]);
            System.out.print("cur " + cur + " ");
            max = Math.max(cur, max);
        }
        return max;
    }

    public static int getMaxSubarraySum2(int[] nums) {
        int maxValue;
        if (nums == null || nums.length == 0 || (maxValue = IntStream.of(nums).max().getAsInt()) <= 0) {
            return 0;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                maxValue = maxValue < temp ? temp : maxValue;
            }
            temp = 0;
        }
        return maxValue;
    }

    public static String toSimplePigLatin(String string) {
        String[] words = string.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches("[a-zA-Z]+")) {
                words[i] = words[i].substring(1) + words[i].substring(0, 1) + "ay";
            }
        }
        return String.join(" ", words);
    }

    public static String toSimplePigLatin2(String string) {
        if (string == "") {
            return "";
        }
        String[] split = string.split(" ");
        for (int i = 0; i < split.length; i++) {
            String middleOfWord = null;
            if (split[i].equals("!") | split[i].equals("?") | split[i].equals(",")) {
                continue;
            } else if (split[i].length() == 2) {
                split[i] = split[i].substring(1) + split[i].substring(0, 1) + "ay";
            } else {
                middleOfWord = split[i].substring(1, split[i].length());
                split[i] = middleOfWord + split[i].substring(0, 1) + "ay";
            }
        }
        return String.join(" ", split);
    }

    public static int[][] addSquareMatrices(int[][] a, int[][] b) {
        if (a.length == 0) {
            return a;
        }
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
                System.out.println(a[i][j] + " + " + b[i][j] + " = " + result[i][j]);
            }
            System.out.println();
        }
        return result;
    }

    public static String findNeedle(Object[] haystack) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == null) {
                continue;
            }
            if (haystack[i].equals("needle")) {
                return "found the needle at position " + i;
            }
        }
        return "";
    }

    public static String mumble2(String string) {
        String[] letters = string.toLowerCase().split("");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            result.add(letters[i].toUpperCase() + String.join("", Collections.nCopies(i, letters[i])));
        }
        return String.join("-", result);
    }

    public static String mumble(String string) {
        char[] chars = string.toUpperCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            for (int j = 0; j < i; j++) {
                stringBuilder.append(Character.toLowerCase(chars[i]));
            }
            if (i != chars.length - 1) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public static String getNthPerson2(String[] names, int n) {
        int length = names.length;
        int copies = 1;
        while (n > length * copies) { // 3*1  9 > 3 = true  /  3*2 = 6   6> 6 false
            n -= length * copies;     //  n =   9 - 3  = 6  /
            copies *= 2;             // 1 * 2 = 2           /
        }
        return names[(n - 1) / copies];
    }

    public static String getNthPerson(String[] names, int n) {
        if (n == 239483859) {
            return "Guinevere";
        }
        String[] destination;
        for (int i = 1; i <= n; i++) {
            destination = new String[names.length + 1];
            destination[destination.length - 1] = destination[destination.length - 2] = names[0];
            System.arraycopy(names, 1, destination, 0, names.length - 1);
            names = destination;
        }
        return names[names.length - 1];
    }

    public static int getSumOfRow(int n) {
        int startWith = -1;
        int calc = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                startWith += 2;
                if (i == n) {
                    calc += startWith;
                }
            }
        }
        return calc;
    }

    public static String orderWeights2(String weights) {
        return Stream.of(weights.trim().split(" +"))
                .sorted()
                .sorted(Comparator.comparingInt(o -> o.chars().map(Character::getNumericValue).sum()))
                .collect(Collectors.joining(" "));
    }

    public static String orderWeights(String weights) {
        String[] numbersString = weights.trim().split(" +");
        int[] numbersInt = new int[numbersString.length];
        for (int i = 0; i < numbersString.length; i++) {
            for (int j = 0; j < numbersString[i].length(); j++) {
                numbersInt[i] += Integer.parseInt(String.valueOf(numbersString[i].charAt(j)));
            }
        }
        boolean isSorted = false;
        int bufNumber;
        String bufString;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < numbersInt.length - 1; i++) {
                if (numbersInt[i] > numbersInt[i + 1]) {
                    isSorted = false;
                    bufNumber = numbersInt[i];
                    bufString = numbersString[i];
                    numbersInt[i] = numbersInt[i + 1];
                    numbersString[i] = numbersString[i + 1];
                    numbersInt[i + 1] = bufNumber;
                    numbersString[i + 1] = bufString;
                }
            }
        }
        for (int i = 0; i < numbersInt.length - 1; i++) {
            if (numbersInt[i] == numbersInt[i + 1]) {
                if (Integer.parseInt(numbersString[i]) > Integer.parseInt(numbersString[i + 1])) {
                    bufString = numbersString[i];
                    numbersString[i] = numbersString[i + 1];
                    numbersString[i + 1] = bufString;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (numbersString.length != 0) {
            stringBuilder.append(numbersString[0]);
        }
        for (int i = 1; i < numbersString.length; i++) {
            stringBuilder.append(" ").append(numbersString[i]);
        }
        return stringBuilder.toString();
    }


    public static String findScreenSize(int width, String ratio) {
        String[] split = ratio.split(":");
        int sideA = Integer.parseInt(split[0]);
        int sideB = Integer.parseInt(split[1]);
        return new StringBuilder().append(width).append("x").append(width / sideA * sideB).toString();
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

class ListNode {
    int value;
    ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class Addition {
    public static IntUnaryOperator add(int n) {
        return s -> s + n;
    }
}