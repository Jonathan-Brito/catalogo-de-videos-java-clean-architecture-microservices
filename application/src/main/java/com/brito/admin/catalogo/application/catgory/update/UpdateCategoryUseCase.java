package com.brito.admin.catalogo.application.catgory.update;

import com.brito.admin.catalogo.application.UseCase;
import com.brito.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
