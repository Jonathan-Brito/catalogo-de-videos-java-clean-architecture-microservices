package com.brito.admin.catalogo.infrastructure.configuration.usecases;

import com.brito.admin.catalogo.application.catgory.create.CreateCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.create.DefaultCreateCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.delete.DefaultDeleteCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.delete.DeleteCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.retrieve.get.DefaultGetCategoryByIdUseCase;
import com.brito.admin.catalogo.application.catgory.retrieve.get.GetCategoryByIdUseCase;
import com.brito.admin.catalogo.application.catgory.retrieve.list.DefaultListCategoriesUseCase;
import com.brito.admin.catalogo.application.catgory.retrieve.list.ListCategoriesUseCase;
import com.brito.admin.catalogo.application.catgory.update.DefaultUpdateCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.update.UpdateCategoryUseCase;
import com.brito.admin.catalogo.domain.category.CategoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryUseCaseConfig {

    private final CategoryGateway categoryGateway;

    public CategoryUseCaseConfig(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(){
        return new DefaultCreateCategoryUseCase(categoryGateway);
    }

    @Bean
    public UpdateCategoryUseCase updateCategoryUseCase(){
        return new DefaultUpdateCategoryUseCase(categoryGateway);
    }

    @Bean
    public GetCategoryByIdUseCase getCategoryByIdUseCase(){
        return new DefaultGetCategoryByIdUseCase(categoryGateway);
    }

    @Bean
    public ListCategoriesUseCase listCategoriesUseCase(){
        return new DefaultListCategoriesUseCase(categoryGateway);
    }

    @Bean
    public DeleteCategoryUseCase deleteCategoryUseCase(){
        return new DefaultDeleteCategoryUseCase(categoryGateway);
    }
}
