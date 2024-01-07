package com.brito.admin.catalogo.infrastructure.utils;

import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

public final class SpecificationUtils {

    private SpecificationUtils() {
    }

    public static <T> Specification<T> like(final String prop, final String term){
        return (root, query, cb) -> cb.like(cb.upper(root.get(prop)), "%" + term.toUpperCase() + "%");
    }
}
