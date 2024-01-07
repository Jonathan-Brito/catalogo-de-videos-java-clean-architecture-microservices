package com.brito.admin.catalogo.infrastructure;

import com.brito.admin.catalogo.application.catgory.create.CreateCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.delete.DeleteCategoryUseCase;
import com.brito.admin.catalogo.application.catgory.retrieve.get.GetCategoryByIdUseCase;
import com.brito.admin.catalogo.application.catgory.retrieve.list.ListCategoriesUseCase;
import com.brito.admin.catalogo.application.catgory.update.UpdateCategoryUseCase;
import com.brito.admin.catalogo.infrastructure.configuration.WebServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "development");
        SpringApplication.run(WebServerConfig.class, args);

    }

   @Bean
   @DependsOnDatabaseInitialization
    public ApplicationRunner applicationRunner(
           @Autowired CreateCategoryUseCase createCategoryUseCase,
           @Autowired UpdateCategoryUseCase updateCategoryUseCase,
           @Autowired ListCategoriesUseCase listCategoriesUseCase,
           @Autowired GetCategoryByIdUseCase getCategoryByIdUseCase,
           @Autowired DeleteCategoryUseCase deleteCategoryUseCase
   ){
        return args -> {


            //List<CategoryJpaEntity> all = categoryRepository.findAll();

            // Criando uma nova categoria
            //Category filmes = Category.newCategory("Filme", null, true);

            // Persistir
            //categoryRepository.saveAndFlush(CategoryJpaEntity.from(filmes));

            // Depois ir até o banco e apagar tudo
            //categoryRepository.deleteAll();
        };
    }
}