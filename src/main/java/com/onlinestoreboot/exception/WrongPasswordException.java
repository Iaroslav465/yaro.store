package com.onlinestoreboot.exception;

import lombok.Getter;

/**
 * Throws if the old password is wrong
 */
@Getter
public class WrongPasswordException extends RuntimeException {

    private final String errorMessage;

    public WrongPasswordException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
