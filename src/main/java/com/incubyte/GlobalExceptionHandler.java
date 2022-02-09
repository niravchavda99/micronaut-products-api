package com.incubyte;

import com.incubyte.product.Product;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

@Singleton
@Requires(classes = {EntityNotFoundException.class, EntityExistsException.class, ExceptionHandler.class})
public class GlobalExceptionHandler implements ExceptionHandler<PersistenceException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, PersistenceException exception) {
        if (exception instanceof EntityNotFoundException) {
            return HttpResponse.notFound("Product with given id not found!");
        } else if (exception instanceof EntityExistsException) {
            return HttpResponse.badRequest("Product already exists!");
        }
        return HttpResponse.serverError("Internal Server Error");
    }
}
