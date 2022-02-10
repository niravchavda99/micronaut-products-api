package com.incubyte.product;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product save(Product product) {
        Optional<Product> existingProduct = productRepository.getByName(product.getName());

        if (existingProduct.isPresent()) {
            throw new EntityExistsException();
        }

        return productRepository.save(product);
    }

    @Transactional
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Product update(Product updatedProduct) {
        return productRepository.update(updatedProduct);
    }

    @Transactional
    public Product getByName(String name) {
        return productRepository.getByName(name).orElseThrow(EntityExistsException::new);
    }

    @Transactional
    public Page<Product> getAllPaged(int page, int size) {
        return productRepository.findAll(Pageable.from(page, size));
    }
}
