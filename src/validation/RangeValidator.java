package validation;

public class RangeValidator {

    // Validate Integer
    public static boolean validateInt(int value, int min, int max) {
        return value >= min && value <= max;
    }

    // Validate Long
    public static boolean validateLong(long value, long min, long max) {
        return value >= min && value <= max;
    }

    // Validate Double
    public static boolean validateDouble(double value, double min, double max) {
        return value >= min && value <= max;
    }
}