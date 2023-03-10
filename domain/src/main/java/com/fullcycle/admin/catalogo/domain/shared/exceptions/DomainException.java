package com.fullcycle.admin.catalogo.domain.shared.exceptions;

import com.fullcycle.admin.catalogo.domain.shared.validation.ValidationError;

import java.util.List;

public class DomainException extends NoStacktraceException {
    private final List<ValidationError> errors;

    private DomainException(List<ValidationError> anErrors) {
        super("");
        this.errors = anErrors;
    }

    public static DomainException with(final ValidationError anError) {
        return new DomainException(List.of(anError));
    }

    public static DomainException with(final List<ValidationError> anErrors) {
        return new DomainException(anErrors);
    }

    public List<ValidationError> getErrors() {
        return this.errors;
    }
}
