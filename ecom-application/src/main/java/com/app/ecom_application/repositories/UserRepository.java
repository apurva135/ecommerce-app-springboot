package com.app.ecom_application.repositories;

import com.app.ecom_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
