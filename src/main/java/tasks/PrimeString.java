package tasks;

public class PrimeString {
    public boolean isPrime(String string) {
//        if (string == "" || string.length() == 1 || string.length() == 3) {
//            return true;
//        }
        for (int i = 0; i < string.length() - 1; i++) {
            String substring = string.substring(i, i + 2);
            for (int j = i + 1; j < string.length() - 1; j++) {
                if (substring.equals(string.substring(j, j + 2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
