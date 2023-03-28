package tasks;

public class WordsLength {
    public int getWordsLength(String[] words) {
        int wordsAmount = 0;
        for (String word : words) {
            int a = word.lastIndexOf('a');
            int z = word.lastIndexOf('z');
            if (a >= 0 && z == -1) {
                wordsAmount = wordsAmount + word.length();
            }
        }
        return wordsAmount;
    }
}