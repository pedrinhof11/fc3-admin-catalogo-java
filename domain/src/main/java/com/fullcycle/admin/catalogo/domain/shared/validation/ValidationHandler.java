package com.fullcycle.admin.catalogo.domain.shared.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(ValidationError anError);
    ValidationHandler append(ValidationHandler anHandler);
    ValidationHandler validate(Validation aValidation);

    List<ValidationError> getErrors();

    default boolean hasError() {
        return getErrors() != null && !getErrors().isEmpty();
    }
    public interface Validation {
        void validate();
    }
}
