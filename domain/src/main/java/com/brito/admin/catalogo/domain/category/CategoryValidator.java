package com.brito.admin.catalogo.domain.category;

import com.brito.admin.catalogo.domain.validation.Error;
import com.brito.admin.catalogo.domain.validation.ValidationHandler;
import com.brito.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;
    protected CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        if (this.category.getName() == null){
                this.validationHandler().append(new Error("'name' should not be null"));
        }
    }
}
