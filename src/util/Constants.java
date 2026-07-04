package util;

public final class Constants {

    // Prevent object creation
    private Constants() {
    }

    // Default numeric ranges
    public static final int DEFAULT_INT_MIN = Integer.MIN_VALUE;
    public static final int DEFAULT_INT_MAX = Integer.MAX_VALUE;

    public static final long DEFAULT_LONG_MIN = Long.MIN_VALUE;
    public static final long DEFAULT_LONG_MAX = Long.MAX_VALUE;

    public static final double DEFAULT_DOUBLE_MIN = -Double.MAX_VALUE;
    public static final double DEFAULT_DOUBLE_MAX = Double.MAX_VALUE;

    // Input settings
    public static final int MAX_INPUT_LENGTH = 100;
    public static final String EMPTY_STRING = "";

    // Locale settings
    public static final char DECIMAL_SEPARATOR = '.';
    public static final char ALTERNATE_DECIMAL_SEPARATOR = ',';
}