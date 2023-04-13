package main.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationMain {
    public static void main(String[] args) {
        String number1 = "(123) 456-7890";
        Pattern pattern1 = Pattern.compile("^(\\([0-9]{3}\\)) ([0-9]{3}-[0-9]{4})$");
        Matcher matcher1 = pattern1.matcher(number1);
        if (matcher1.matches()){
            System.out.println("valid1");
        }else {
            System.out.println("don't 1");
        }




        String number2 = "+380442283228";
        Pattern pattern2 = Pattern.compile("^((\\+?380)([0-9]{9}))$");
        Pattern pattern2_1 = Pattern.compile("^((\\+?380)([\\d]{9}))$");
        Pattern pattern2_2 = Pattern.compile("^((\\+?380)([\\p{Digit}]{9}))$");
        Matcher matcher = pattern2.matcher(number2);
        if (matcher.matches()){
            System.out.println("valid2");
        }
    }
}
