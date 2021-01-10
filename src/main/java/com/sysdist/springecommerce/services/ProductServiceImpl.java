package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Product;
import com.sysdist.springecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final List<Product> products;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.getProductByName(name);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product p: products)
            if (p.getId() == id)
                return p;

            return null;
    }
}
