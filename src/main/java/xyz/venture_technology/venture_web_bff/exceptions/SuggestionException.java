package xyz.venture_technology.venture_web_bff.exceptions;

public class SuggestionException extends RuntimeException {

    public SuggestionException(String message) {
        super(message);
    }

    public SuggestionException(String message, Throwable cause) {
        super(message, cause);
    }

}
