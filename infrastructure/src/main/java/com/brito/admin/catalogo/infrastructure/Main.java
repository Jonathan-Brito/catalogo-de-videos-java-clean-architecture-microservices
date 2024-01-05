package com.brito.admin.catalogo.infrastructure;

import com.brito.admin.catalogo.domain.category.Category;
import com.brito.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity;
import com.brito.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import com.brito.admin.catalogo.infrastructure.configuration.WebServerConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "development");
        SpringApplication.run(WebServerConfig.class, args);

    }

   /* @Bean
    public ApplicationRunner applicationRunner(CategoryRepository categoryRepository){
        return args -> {
            List<CategoryJpaEntity> all = categoryRepository.findAll();

            // Criando uma nova categoria
            Category filmes = Category.newCategory("Filme", null, true);

            // Persistir
            categoryRepository.saveAndFlush(CategoryJpaEntity.from(filmes));

            // Depois ir até o banco e apagar tudo
            categoryRepository.deleteAll();
        };
    }*/
}