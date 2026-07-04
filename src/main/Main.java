package main;

import java.util.Scanner;

import model.ErrorType;
import model.ParseResult;
import parser.LocaleNormalizer;
import parser.NumberDetector;
import parser.NumericParser;
import validation.RangeValidator;

public class Main {

	public static void printError(ErrorType errorType) {
		
		switch (errorType) {
		
		case NULL_INPUT:
			System.out.println("Error: Input is null.");
			break;
			
		case EMPTY_INPUT:
			System.out.println("Error: Input is empty.");
			break;
			
		case ALPHABETIC_CHARACTERS:
			System.out.println("Error: Input contains alphabetic characters.");
			break;
			
		case INVALID_SPECIAL_CHARACTERS:
			System.out.println("Error: Input contains invalid special characters.");
			break;
			
		case INVALID_SIGN:
			System.out.println("Error: Invalid sign placement.");
			break;
			
		case MULTIPLE_DECIMAL_POINTS:
			System.out.println("Error: Multiple decimal points are not allowed.");
			break;
			
		case DECIMAL_NOT_ALLOWED:
			System.out.println("Error: Decimal numbers are not allowed for Integer/Long.");
			break;
			
		case INTEGER_OVERFLOW:
			System.out.println("Error: Integer value is out of range.");
			break;
			
		case LONG_OVERFLOW:
			System.out.println("Error: Long value is out of range.");
			break;
			
		case DOUBLE_OVERFLOW:
			System.out.println("Error: Double value is out of range.");
			break;
			
		default:
			System.out.println("Unknown Error.");
		}
	}
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("===== Numeric Parser Utility =====");

            System.out.print("Enter a number: ");
            String input = sc.nextLine();

            // Normalize input
            String normalized = LocaleNormalizer.normalize(input);

            System.out.println("Normalized Input : " + normalized);

            // Detect type
            String type = NumberDetector.detectType(normalized);

            System.out.println("Detected Type    : " + type);

            switch (type) {

            case "INTEGER":

                ParseResult<Integer> intResult = NumericParser.parseInt(normalized);

                if (intResult.isSuccess()) {

                    System.out.println("Parsed Value     : " + intResult.getValue());

                    if (RangeValidator.validateInt(intResult.getValue(), 0, 100)) {
                        System.out.println("Range Check      : Valid");
                    } else {
                        System.out.println("Range Check      : Out of Range");
                    }

                } else {

                    printError(intResult.getErrorType());

                }

                break;

            case "LONG":

                ParseResult<Long> longResult = NumericParser.parseLong(normalized);

                if (longResult.isSuccess()) {

                    System.out.println("Parsed Value     : " + longResult.getValue());

                    if (RangeValidator.validateLong(longResult.getValue(), 0L, 100000000000L)) {
                        System.out.println("Range Check      : Valid");
                    } else {
                        System.out.println("Range Check      : Out of Range");
                    }

                } else {

                    printError(longResult.getErrorType());

                }

                break;

            case "DOUBLE":

                ParseResult<Double> doubleResult = NumericParser.parseDouble(normalized);

                if (doubleResult.isSuccess()) {

                    System.out.println("Parsed Value     : " + doubleResult.getValue());

                    if (RangeValidator.validateDouble(doubleResult.getValue(), 0.0, 100.0)) {
                        System.out.println("Range Check      : Valid");
                    } else {
                        System.out.println("Range Check      : Out of Range");
                    }

                } else {

                    printError(doubleResult.getErrorType());

                }

                break;

            default:
//                System.out.println("Error: Invalid input format.");
            	
            }

        } catch (Exception e) {

            System.out.println("Unexpected Error: " + e.getMessage());

        } finally {

            sc.close();

        }
    }

}