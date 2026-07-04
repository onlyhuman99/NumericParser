package model;

public class ParseResult<T> {

    private boolean success;
    private T value;
    private ErrorType errorType;

    public ParseResult(boolean success, T value, ErrorType errorType) {
        this.success = success;
        this.value = value;
        this.errorType = errorType;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getValue() {
        return value;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}