package com.incubyte.product;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PageableRepository<Product, Long> {
    Optional<Product> getByName(String name);
}
