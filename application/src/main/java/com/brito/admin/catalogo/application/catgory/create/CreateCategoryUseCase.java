package com.brito.admin.catalogo.application.catgory.create;

import com.brito.admin.catalogo.application.UseCase;
import com.brito.admin.catalogo.application.catgory.create.CreateCategoryCommand;
import com.brito.admin.catalogo.application.catgory.create.CreateCategoryOutput;
import com.brito.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
