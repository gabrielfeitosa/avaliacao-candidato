package com.gabriel.avaliacao.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gabriel on 23/04/17.
 */
public class EmailValidator {

    public final static String EMAIL_PATTERN = "^[a-z]+[a-z0-9._]+@[a-z]+\\.[a-z.]+$";
    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);;

    private EmailValidator() {}

    public static boolean validar(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
