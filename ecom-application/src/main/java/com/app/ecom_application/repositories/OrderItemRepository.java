package com.app.ecom_application.repositories;

import com.app.ecom_application.model.OrderItem;
import com.app.ecom_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long> {
}
