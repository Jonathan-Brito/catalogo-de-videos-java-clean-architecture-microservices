package com.brito.admin.catalogo.domain.category;

import com.brito.admin.catalogo.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {

    Optional<Category> findById(CategoryID anId);

    Pagination<Category> findAll(CategorySearchQuery aQuery);

    Category create(Category aCategory);

    Category update(Category aCategory);

    void deleteById(CategoryID anId);
}
