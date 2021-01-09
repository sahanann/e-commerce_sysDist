package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product findById(Long id);
    Product findByName(String name);
}
