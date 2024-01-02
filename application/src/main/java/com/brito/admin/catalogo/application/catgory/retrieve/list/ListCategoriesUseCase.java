package com.brito.admin.catalogo.application.catgory.retrieve.list;

import com.brito.admin.catalogo.application.UseCase;
import com.brito.admin.catalogo.domain.category.CategorySearchQuery;
import com.brito.admin.catalogo.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
