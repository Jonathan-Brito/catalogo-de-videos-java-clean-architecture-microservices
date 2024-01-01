package com.brito.admin.catalogo.application.catgory.update;

import com.brito.admin.catalogo.domain.category.Category;
import com.brito.admin.catalogo.domain.category.CategoryID;

public record UpdateCategoryOutput(
        CategoryID id
) {
    public static UpdateCategoryOutput from(final Category aCategory){
        return new UpdateCategoryOutput(aCategory.getId());
    }
}
