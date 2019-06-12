package com.morgana.common.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 5551864812062891054L;

    public BaseException(String message) {
        super(message);
    }

}
