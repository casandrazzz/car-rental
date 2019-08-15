package com.spring.rental.exceptions;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a managed, application specific exception. Subclass this exception in case the caller can take meaningful
 * action based on the kind of exception.
 */
public class ApplicationException extends Exception {
    /**
     * @param message the error message
     */
    public ApplicationException(final String message) {
        super(message);
    }

    /**
     * @param message the error message
     * @param cause   the cause of the exception
     */
    public ApplicationException(String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Returns a {@link Supplier}&lt;{@link WrappedApplicationException}&gt; for the given id and domainClass.
     * The intended usecase for this method is within for {@link Optional#orElseThrow(Supplier)}
     *
     * @param message the exception message
     * @return a supplier for a wrapped {@link ApplicationException}
     */
    public static Supplier<WrappedApplicationException> wrapped(String message) {
        return () -> new WrappedApplicationException(new ApplicationException(message));
    }
}