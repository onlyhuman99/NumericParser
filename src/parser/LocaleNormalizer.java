package parser;

public class LocaleNormalizer {

    /**
     * Normalizes numeric input.
     * - Removes leading/trailing spaces
     * - Removes spaces inside the number
     * - Converts comma decimal separator to dot
     */
    public static String normalize(String input) {

        if (input == null) {
            return null;
        }

        input = input.trim();

        // Remove spaces inside the number
        input = input.replace(" ", "");

        // Convert comma to decimal point
        input = input.replace(',', '.');

        return input;
    }
}