package tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Drinking {
    public String hydrate(String drinks) {
        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(drinks);
        int count = 0;
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if (number > 0) {
                count += number;
            }
        }
        if (count == 1) {
            return "1 glass of water";
        }
        return count + " glasses of water";
    }
}
