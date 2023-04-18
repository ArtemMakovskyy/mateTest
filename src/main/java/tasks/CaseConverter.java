package tasks;

public class CaseConverter {
    public String convertString(String string) {
        int upperCase = 0;
        int lowerCase = 0;
        for (int i = 0; i < string.length(); i++) {
            String s = String.valueOf(string.charAt(i));
            if (s == s.toUpperCase()) {
                upperCase++;
            } else {
                lowerCase++;
            }
        }
        return upperCase > lowerCase ? string.toUpperCase() : string.toLowerCase();
    }
}
