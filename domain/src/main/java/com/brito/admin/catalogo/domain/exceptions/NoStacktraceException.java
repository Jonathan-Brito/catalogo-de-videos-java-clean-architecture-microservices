package com.brito.admin.catalogo.domain.exceptions;

public class NoStacktraceException extends RuntimeException{

    public NoStacktraceException(final String message) {
        this(message, null);
    }

    public NoStacktraceException(final String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
