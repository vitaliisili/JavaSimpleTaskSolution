import java.util.Arrays;

/*
*  In this example you have to validate if a user input string is alphanumeric. The given string is not null,
*  so you don't have to check that.

*  The string has the following conditions to be alphanumeric:

*  At least one character ("" is not valid)
*  Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
*  No whitespaces / underscore*/
public class AlphaNumericString {
    public static void main(String[] args) {
        String s1 = "rzx7iQHHL3DPtzRkbbj3eIkXYCVFtHHU7bvAMtXg7nCOr";
        String s2 = "Z?Dd>SS";
        System.out.println(isAlphaNumeric(s1)); // true
        System.out.println(isAlphaNumeric(s2)); // false
    }

    public static boolean isAlphaNumeric(String s) {
        return s.replaceFirst("[a-zA-Z0-9]+", "check").equals("check");
    }
}
