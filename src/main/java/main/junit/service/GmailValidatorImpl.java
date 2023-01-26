package main.junit.service;

public class GmailValidatorImpl implements EmailValidator {
    @Override
    public boolean isValid(String email) {

        if (!Character.isLetter(email.charAt(0))){
            return false;
        }
        return true;
    }
}
