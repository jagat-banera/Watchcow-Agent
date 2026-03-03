package org.example.CustomExceptions;

public class PropertyFileException extends RuntimeException{
    public PropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
