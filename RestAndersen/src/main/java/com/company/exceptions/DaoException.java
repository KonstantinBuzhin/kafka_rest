package com.company.exceptions;

public class DaoException extends RuntimeException {

    public DaoException(String format, Object... args) {
        super(String.format(format, args));
    }

    public DaoException(String format, Throwable cause, Object... args) {
        super(String.format(format, args), cause);
    }
}
