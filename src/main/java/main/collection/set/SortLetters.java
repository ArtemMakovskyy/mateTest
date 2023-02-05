package main.collection.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortLetters {
    private static final int MAX_UNIQUE_LETTERS_NUMBER = 5;

    public String getUniqueCharacters(String text) {
        char[] chars = text.toLowerCase().toCharArray();
        Set<Character> characterSet = new TreeSet<>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                characterSet.add(aChar);
            }
        }
        List<Character> characterList = new ArrayList<>(characterSet);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < (Math.min(characterList.size(), MAX_UNIQUE_LETTERS_NUMBER)); i++) {
            stringBuilder.append(characterList.get(i));
        }
        return stringBuilder.toString();
    }
    public String getUniqueCharacters2(String text) {
        Set<Character> uniqueLetters = new TreeSet<>();
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            if (Character.isLetter(symbol)) {
                uniqueLetters.add(Character.toLowerCase(symbol));
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character character : uniqueLetters) {
            if (result.length() == MAX_UNIQUE_LETTERS_NUMBER) {
                break;
            }
            result.append(character);
        }
        return result.toString();
    }
}
