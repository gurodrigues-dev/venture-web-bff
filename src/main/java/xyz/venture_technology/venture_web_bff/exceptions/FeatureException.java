package xyz.venture_technology.venture_web_bff.exceptions;

public class FeatureException extends RuntimeException{

    public FeatureException(String message) {
        super(message);
    }

    public FeatureException(String message, Throwable cause) {
        super(message, cause);
    }

}
