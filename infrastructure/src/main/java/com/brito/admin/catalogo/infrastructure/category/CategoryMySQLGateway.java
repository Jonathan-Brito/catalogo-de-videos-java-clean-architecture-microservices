package com.brito.admin.catalogo.infrastructure.category;

import com.brito.admin.catalogo.domain.category.Category;
import com.brito.admin.catalogo.domain.category.CategoryGateway;
import com.brito.admin.catalogo.domain.category.CategoryID;
import com.brito.admin.catalogo.domain.category.CategorySearchQuery;
import com.brito.admin.catalogo.domain.pagination.Pagination;
import com.brito.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity;
import com.brito.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import com.brito.admin.catalogo.infrastructure.utils.SpecificationUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.brito.admin.catalogo.infrastructure.utils.SpecificationUtils.like;

@Service
public class CategoryMySQLGateway implements CategoryGateway {

    private final CategoryRepository categoryRepository; // respository se comunica com o Hibernate que faz toda comunicação

    public CategoryMySQLGateway(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findById(final CategoryID anId) {
        // Indo até o banco de dados se não existe não entra no map mas se existir entrar no map e converter o dado do banco para o agregado de categoria
        return this.categoryRepository.findById(anId.getValue()).map(CategoryJpaEntity::toAggregate);
    }

    @Override
    public Pagination<Category> findAll(final CategorySearchQuery aQuery) {
        // Paginação
        final var page = PageRequest.of(
                aQuery.page(),
                aQuery.perPage(),
                Sort.by(Sort.Direction.fromString(aQuery.direction()), aQuery.sort())
        );

        // Busca dinamica pelo criterio terms (name ou description)
        final var specifications = Optional.ofNullable(aQuery.terms())
                .filter(str -> !str.isBlank())
                .map(str -> {
                    return SpecificationUtils
                            .<CategoryJpaEntity>like("name", str)
                            .or(like("description", str));
                })
                .orElse(null);

        final var pageResult =
                this.categoryRepository.findAll(Specification.where(specifications), page);

        return new Pagination<>(
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.map(CategoryJpaEntity::toAggregate).toList()
        );
    }

    @Override
    public Category create(final Category aCategory) {

        return this.categoryRepository.save(CategoryJpaEntity.from(aCategory))
                .toAggregate(); // Converter
    }

    @Override
    public Category update(final Category aCategory) {

        return this.categoryRepository.save(CategoryJpaEntity.from(aCategory)).toAggregate();
    }

    @Override
    public void deleteById(final CategoryID anId) {
        final String anIdValue = anId.getValue();
        if (this.categoryRepository.existsById(anIdValue)){
            this.categoryRepository.deleteById(anIdValue);
        }
    }
}
