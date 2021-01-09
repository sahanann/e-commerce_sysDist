package com.sysdist.springecommerce.repositories;

import com.sysdist.springecommerce.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product getProductByName(@Param("productName") String name);
}
