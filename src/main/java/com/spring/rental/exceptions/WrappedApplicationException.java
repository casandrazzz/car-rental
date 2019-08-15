package com.spring.rental.exceptions;

/** Wraps a managed application exception into a runtime exception. Use this to avoid pollution of interfaces or in
 * circumstances where the method signature can not be changed.
 */
public class WrappedApplicationException extends RuntimeException {
    private final ApplicationException applicationException;

    /**
     * @param applicationException the application exception
     */
    public WrappedApplicationException(final ApplicationException applicationException) {
        super(applicationException);
        if (applicationException == null) {
            throw new IllegalArgumentException("applicationException must not be null");
        }
        this.applicationException = applicationException;
    }

    /**
     * @return the wrapped application exception
     */
    public ApplicationException getApplicationException() {
        return applicationException;
    }

}