package codewars.task1;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
    public static void main(String[] args) {

        System.out.println(high("b aa"));
    }
    public static String high(String s) {
        String[] words = s.split(" ");
        int maxScore = 0;
        String highestWord = "";

        for (String word : words) {
            int score = calculateScore(word);
            if (score > maxScore || (score == maxScore && word.compareTo(highestWord) < 0)) {
                maxScore = score;
                highestWord = word;
            }
        }

        return highestWord;
    }

    private static int calculateScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += c - 'a' + 1;
        }
        return score;
    }


    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int freq : charFrequency.values()) {
            if (freq > 1) {
                count++;
            }
        }
        return count;
    }
}