package parser;

public class NumberDetector {

    /**
     * Detects whether the input is an Integer, Long, Double or Invalid.
     */
    public static String detectType(String input) {

        if (input == null || input.trim().isEmpty()) {
            return "INVALID";
        }

        input = LocaleNormalizer.normalize(input);

        try {
            Integer.parseInt(input);
            return "INTEGER";
        } catch (NumberFormatException e) {
            // Ignore and try next type
        }

        try {
            Long.parseLong(input);
            return "LONG";
        } catch (NumberFormatException e) {
            // Ignore and try next type
        }

        try {
            Double.parseDouble(input);
            return "DOUBLE";
        } catch (NumberFormatException e) {
            return "INVALID";
        }
    }
}