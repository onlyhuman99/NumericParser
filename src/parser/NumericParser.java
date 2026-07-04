package parser;

import model.ErrorType;
import model.ParseResult;

public class NumericParser {

    public static ParseResult<Integer> parseInt(String input) {

        if (input == null)
            return new ParseResult<>(false, null, ErrorType.NULL_INPUT);

        input = input.trim();

        if (input.isEmpty())
            return new ParseResult<>(false, null, ErrorType.EMPTY_INPUT);

        if (input.matches(".*[a-zA-Z].*"))
            return new ParseResult<>(false, null, ErrorType.ALPHABETIC_CHARACTERS);

        if (input.contains(".") || input.contains(","))
            return new ParseResult<>(false, null, ErrorType.DECIMAL_NOT_ALLOWED);

        if (input.matches(".*[+-].*[+-].*"))
            return new ParseResult<>(false, null, ErrorType.INVALID_SIGN);

        if (!input.matches("[+-]?\\d+"))
            return new ParseResult<>(false, null, ErrorType.INVALID_SPECIAL_CHARACTERS);

        try {
            int value = Integer.parseInt(input);
            return new ParseResult<>(true, value, ErrorType.SUCCESS);

        } catch (NumberFormatException e) {
            return new ParseResult<>(false, null, ErrorType.INTEGER_OVERFLOW);
        }
    }

    public static ParseResult<Long> parseLong(String input) {

        if (input == null)
            return new ParseResult<>(false, null, ErrorType.NULL_INPUT);

        input = input.trim();

        if (input.isEmpty())
            return new ParseResult<>(false, null, ErrorType.EMPTY_INPUT);

        if (input.matches(".*[a-zA-Z].*"))
            return new ParseResult<>(false, null, ErrorType.ALPHABETIC_CHARACTERS);

        if (input.contains(".") || input.contains(","))
            return new ParseResult<>(false, null, ErrorType.DECIMAL_NOT_ALLOWED);

        if (input.matches(".*[+-].*[+-].*"))
            return new ParseResult<>(false, null, ErrorType.INVALID_SIGN);

        if (!input.matches("[+-]?\\d+"))
            return new ParseResult<>(false, null, ErrorType.INVALID_SPECIAL_CHARACTERS);

        try {
            long value = Long.parseLong(input);
            return new ParseResult<>(true, value, ErrorType.SUCCESS);

        } catch (NumberFormatException e) {
            return new ParseResult<>(false, null, ErrorType.LONG_OVERFLOW);
        }
    }

    public static ParseResult<Double> parseDouble(String input) {

        if (input == null)
            return new ParseResult<>(false, null, ErrorType.NULL_INPUT);

        input = input.trim().replace(',', '.');

        if (input.isEmpty())
            return new ParseResult<>(false, null, ErrorType.EMPTY_INPUT);

        if (input.matches(".*[a-zA-Z].*"))
            return new ParseResult<>(false, null, ErrorType.ALPHABETIC_CHARACTERS);

        if (input.indexOf('.') != input.lastIndexOf('.'))
            return new ParseResult<>(false, null, ErrorType.MULTIPLE_DECIMAL_POINTS);

        if (input.matches(".*[+-].*[+-].*"))
            return new ParseResult<>(false, null, ErrorType.INVALID_SIGN);

        if (!input.matches("[+-]?\\d+(\\.\\d+)?"))
            return new ParseResult<>(false, null, ErrorType.INVALID_SPECIAL_CHARACTERS);

        try {
            double value = Double.parseDouble(input);
            return new ParseResult<>(true, value, ErrorType.SUCCESS);

        } catch (NumberFormatException e) {
            return new ParseResult<>(false, null, ErrorType.DOUBLE_OVERFLOW);
        }
    }
}