package saman.problem.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class StringUtils {

    private static Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    private static Set<Character> consonants = new HashSet<>(Arrays.asList('b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z','B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'));
    private static Set<Character> digits = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));

    private StringUtils() {}

    /**
     * Given a string, remove all the vowels from it.
     * e.g. if string = "fdatuqiq", then return "fdtqq"
     * @param string the String to be operated on
     * @return
     */
    public static String removeVowels(String string) {
        char[] result = new char[string.length()];
        int j = 0;
        for (int i = 0; i< string.length(); i++) {
            if (!isVowel(string.charAt(i))) {
                result[j] = string.charAt(i);
                j++;
            }
        }
        return new String(Arrays.copyOfRange(result, 0, j));
    }

    public static boolean isVowel(char character) {
        return vowels.contains(character);
    }

    public static boolean isConsonant(char character) {
        return consonants.contains(character);
    }

    public static boolean isDigit(char character) {
        return digits.contains(character);
    }
}
