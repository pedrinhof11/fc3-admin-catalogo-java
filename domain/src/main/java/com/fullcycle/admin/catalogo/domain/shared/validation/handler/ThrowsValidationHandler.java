package com.fullcycle.admin.catalogo.domain.shared.validation.handler;

import com.fullcycle.admin.catalogo.domain.shared.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.shared.validation.ValidationError;
import com.fullcycle.admin.catalogo.domain.shared.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(final ValidationError anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception exception) {
            throw DomainException.with(new ValidationError(exception.getMessage()));
        }
        return this;
    }

    @Override
    public List<ValidationError> getErrors() {
        return List.of();
    }
}
