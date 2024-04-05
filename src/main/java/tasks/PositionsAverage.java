package tasks;

public class PositionsAverage {
//    public static double getAveragePercentage(String string) {
//        String[] split = string.split(",\\s*");
//        int n = split.length;
//        int totalCombinations = (n * (n - 1)) / 2;
//        int totalMatchingPositions = 0;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int matchingPositions = 0;
//                for (int f = 0; f < Math.min(split[i].length(), split[j].length()); f++) {
//                    if (split[i].charAt(f) == split[j].charAt(f)) {
//                        matchingPositions++;
//                    }
//                }
//                totalMatchingPositions += matchingPositions;
//            }
//        }
//        double averagePercentage = (double) totalMatchingPositions / totalCombinations * 100;
//        return averagePercentage;
//    }
public static double getAveragePercentage(String string) {
    String[] numbers = string.split(", ");
    int n = numbers.length;
    int count = 0;
    double sum = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            int common = countCommon(numbers[i], numbers[j]);
            count++;
            sum += ((double) common / numbers[i].length() * numbers[j].length());
        }
    }
    return sum / count * 100;
}

    private static int countCommon(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490";
        double result = getAveragePercentage(input);
        System.out.println("Average Percentage: " + result);
    }
}