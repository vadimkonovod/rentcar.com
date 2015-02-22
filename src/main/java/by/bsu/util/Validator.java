package by.bsu.util;

import by.bsu.exception.IllegalEmailValidationException;
import by.bsu.exception.IllegalOldPasswordException;
import by.bsu.exception.IllegalPasswordValidationException;

import java.util.regex.Pattern;

public class Validator {

    private Validator() {
    }

    public static void emailValidate(String emailToValidate, String emailFormat) throws IllegalEmailValidationException {

        if (emailToValidate == null) {
            throw new IllegalEmailValidationException();
        }

        if (!Pattern.matches(emailFormat, emailToValidate)) {
            throw new IllegalEmailValidationException();
        }
    }

    public static void passwordValidate(String pass, String verPass) throws IllegalPasswordValidationException {
        if (pass == null || pass == "") {
            throw new IllegalPasswordValidationException();
        }

        if (verPass == null || verPass == "") {
            throw new IllegalPasswordValidationException();
        }

        if (!pass.equals(verPass)) {
            throw new IllegalPasswordValidationException();
        }
    }
}