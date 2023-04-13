package main.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static boolean isValid(String phoneNumber) {
        Pattern pattern = Pattern
                .compile("^(\\([0-9]{3}\\)) ([0-9]{3}-[0-9]{4})$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}