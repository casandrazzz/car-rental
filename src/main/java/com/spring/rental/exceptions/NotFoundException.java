package com.spring.rental.exceptions;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Exception indicating that an entity could not be found.
 */
public class NotFoundException extends ApplicationException {
    private final Serializable id;
    private final Class<?> domainClass;

    /**
     * @param id          the id of the object which was not found
     * @param domainClass the class of the entity which was not found
     */
    public NotFoundException(final Serializable id, final Class<?> domainClass) {
        super("Object not found");
        this.id = id;
        this.domainClass = domainClass;
    }


    /**
     * Returns a {@link Supplier}&lt;{@link WrappedApplicationException}&gt; for the given id and domainClass.
     * The intended use case for this method is within for {@link Optional#orElseThrow(Supplier)}
     *
     * @param id          the id of the domain object
     * @param domainClass the class of the domain object
     * @return a supplier for a wrapped {@link NotFoundException}
     */
    public static Supplier<WrappedApplicationException> wrapped(final Serializable id, final Class<?> domainClass) {
        return () -> new WrappedApplicationException(new NotFoundException(id, domainClass));
    }

    @Override
    public String getMessage() {
        String type = domainClass != null ? domainClass.getSimpleName() : "unknown";
        return String.format("Object of type %s with id %s not found", type, id);
    }

    /**
     * @return the id of the domain entity
     */
    public Serializable getId() {
        return id;
    }

    /**
     * @return the class of the domain entity
     */
    public Class<?> getDomainClass() {
        return domainClass;
    }
}