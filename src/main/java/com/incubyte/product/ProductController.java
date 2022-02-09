package com.incubyte.product;

import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get
    public List<Product> getAll() {
        return productService.getAll();
    }

    @Get("/{id}")
    public Product getById(Long id) {
        return productService.getById(id);
    }

    @Post
    public Product save(@Body Product product) {
        return productService.save(product);
    }

    @Patch
    public Product update(@Body Product updatedProduct) {
        return productService.update(updatedProduct);
    }
}
