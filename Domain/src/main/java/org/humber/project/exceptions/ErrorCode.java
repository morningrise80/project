package org.humber.project.exceptions;

public enum ErrorCode {
    INVALID_RESTAURANT_ID("Invalid restaurant id"),
    INVALID_RESTAURANT_NAME("Invalid restaurant name");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
