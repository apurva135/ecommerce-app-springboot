package com.app.ecom_application.repositories;

import com.app.ecom_application.model.Product;
import com.app.ecom_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
