package com.incubyte.product;

import jakarta.inject.Singleton;

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
        return productRepository.save(product);
    }

    @Transactional
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return  product.get();
    }

    @Transactional
    public Product update(Product updatedProduct) {
        return productRepository.update(updatedProduct);
    }
}
