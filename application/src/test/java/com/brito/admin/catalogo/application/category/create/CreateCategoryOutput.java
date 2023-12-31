package com.brito.admin.catalogo.application.category.create;

import com.brito.admin.catalogo.domain.category.Category;
import com.brito.admin.catalogo.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {

    public static CreateCategoryOutput from(final Category aCategory){
        return new CreateCategoryOutput(aCategory.getId());
    }

}
