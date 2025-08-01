package com.app.ecom_application.repositories;

import com.app.ecom_application.model.Cart;
import com.app.ecom_application.model.CartItem;
import com.app.ecom_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
