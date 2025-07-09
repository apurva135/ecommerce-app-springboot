package com.app.ecom_application.repositories;

import com.app.ecom_application.model.Address;
import com.app.ecom_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, Long> {
}
