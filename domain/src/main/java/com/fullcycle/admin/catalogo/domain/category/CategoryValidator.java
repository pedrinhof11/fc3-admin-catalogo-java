package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.shared.validation.ValidationError;
import com.fullcycle.admin.catalogo.domain.shared.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.shared.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;

    public CategoryValidator(Category aCategory, ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        if(this.category.getName() == null ) {
            this.validationHandler().append(new ValidationError("Name should not be null"));
        }
    }
}
