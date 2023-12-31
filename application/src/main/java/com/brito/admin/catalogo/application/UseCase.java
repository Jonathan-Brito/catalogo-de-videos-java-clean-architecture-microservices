package com.brito.admin.catalogo.application;

import com.brito.admin.catalogo.domain.category.Category;

public abstract class UseCase<IN, OUT> {
    public abstract OUT execute(IN anIn);
}