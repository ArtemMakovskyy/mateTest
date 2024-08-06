package live.coding;

public class Solution58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        while (s.startsWith(" ") || s.endsWith(" ")) {
            if (s.startsWith(" ")) {
                s = s.substring(1, s.length());
            }
            if (s.endsWith(" ")) {
                s = s.substring(0, s.length() - 1);
            }
        }
        final int i = s.lastIndexOf(" ");
        return s.length() - i - 1;
    }

    public static int lengthOfLastWord2(String s) {
        s = "   fly me   to   the moon  ";
        s = s.trim();
        final int i = s.lastIndexOf(" ");
        return s.length() - i - 1;
    }
}
