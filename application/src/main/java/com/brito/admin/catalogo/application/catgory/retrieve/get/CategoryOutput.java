package com.brito.admin.catalogo.application.catgory.retrieve.get;

import com.brito.admin.catalogo.domain.category.Category;
import com.brito.admin.catalogo.domain.category.CategoryID;

import java.time.Instant;

public record CategoryOutput(
        CategoryID id,
        String name,
        String description,
        boolean isActive,
        Instant createdAt,

        Instant updatedAt,

        Instant deletedAt
) {
    public static CategoryOutput from(final Category aCategory){
      return new CategoryOutput(
              aCategory.getId(),
              aCategory.getName(),
              aCategory.getDescription(),
              aCategory.isActive(),
              aCategory.getCreatedAt(),
              aCategory.getUpdatedAt(),
              aCategory.getDeletedAt()
      );
    }
}
