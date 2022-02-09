package com.incubyte.product;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
