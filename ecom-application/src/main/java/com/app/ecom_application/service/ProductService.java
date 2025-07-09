package com.app.ecom_application.service;

import com.app.ecom_application.model.Product;

import java.util.List;


public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(Long Id);
    Product updateProduct(Long Id, Product updatedProduct);
    Void deleteProduct(Long Id);
}
