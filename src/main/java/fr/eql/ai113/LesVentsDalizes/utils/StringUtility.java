package fr.eql.ai113.LesVentsDalizes.utils;

import java.text.Normalizer;

/**
 * This utility class allows to centralize the methods that could be useful in the whole program
 */
public class StringUtility {

    public static String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    /**
     * This method will compare strings without taking into account accents and case
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCaseAndAccent(String str1, String str2) {
        String normalizedStr1 = normalizeString(str1);
        String normalizedStr2 = normalizeString(str2);
        return normalizedStr1.equalsIgnoreCase(normalizedStr2);
    }
}
