package tasks;

public class Passphrase {
    private static final int ENGLISH_CHARS_NUMBERS_IN_ALPHABET = 26;

    public static String createPassphrase(String phrase, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            char phraseChar = phrase.charAt(i);
            if (Character.isLetter(phraseChar)) {
                char shiftedChar = (char) (phraseChar + shift);
                if (Character.isUpperCase(phraseChar)) {
                    int upperCharAlphabetPosition = shiftedChar - 'A';
                    int shiftPosition = upperCharAlphabetPosition % ENGLISH_CHARS_NUMBERS_IN_ALPHABET;
                    shiftedChar = (char) ('A' + shiftPosition);
                } else {
                    int lowerCharAlphabetPosition = shiftedChar - 'a';
                    int shiftPosition = lowerCharAlphabetPosition % ENGLISH_CHARS_NUMBERS_IN_ALPHABET;
                    shiftedChar = (char) ('a' + (lowerCharAlphabetPosition % ENGLISH_CHARS_NUMBERS_IN_ALPHABET));
                }
                boolean isPairDigit = i % 2 == 0;
                if (isPairDigit) {
                    result.append(Character.toUpperCase(shiftedChar));
                } else {
                    result.append(Character.toLowerCase(shiftedChar));
                }
            } else if (Character.isDigit(phraseChar)) {
                int digit = Character.getNumericValue(phraseChar);
                int encryptedDigit = 9 - digit;
                result.append(encryptedDigit);
            } else {
                result.append(phraseChar);
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(29 % 26);
        String phrase = "BORN IN 2015!";
        int shift = 1;
        String passphrase = createPassphrase(phrase, shift);
        System.out.println(passphrase); // Вивід: "!4897 Oj oSpC"
    }
}