package com.brito.admin.catalogo.application.catgory.retrieve.get;

import com.brito.admin.catalogo.domain.category.CategoryGateway;
import com.brito.admin.catalogo.domain.category.CategoryID;
import com.brito.admin.catalogo.domain.exceptions.DomainException;
import com.brito.admin.catalogo.domain.validation.Error;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetCategoryByIdUseCase extends GetCategoryByIdUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultGetCategoryByIdUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CategoryOutput execute(final String anIn) {
        final var anCategoryId = CategoryID.from(anIn);

        return this.categoryGateway.findById(anCategoryId)
                .map(CategoryOutput::from)
                .orElseThrow(notFound(anCategoryId));
    }

    private Supplier<DomainException> notFound(final CategoryID anId){
        return () -> DomainException.with(new Error("Category with ID %s was not found".formatted(anId.getValue())));
    }
}
