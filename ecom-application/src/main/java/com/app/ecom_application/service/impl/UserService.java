package com.app.ecom_application.service.impl;

import com.app.ecom_application.model.User;
import com.app.ecom_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    List<User> userList = new ArrayList<>();

    @Autowired
    UserRepository userRepository;

    public List<User> fetchUser()
    {
//        return userList;
        return userRepository.findAll();
    }

    public List<User> addUser(User user)
    {
//        userList.add(user);
//        return userList;
        userRepository.save(user);
        return userList;
    }

    public Optional<User> fetchUser(Long id)
    {
       return userList.stream()
               .filter(user -> user.getId().equals(id))
               .findFirst();
    }

    public boolean updateUser(Long id, User updatedUser)
    {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(
                        existingUser ->{
                            existingUser.setFirstName(updatedUser.getFirstName());
                            existingUser.setLastName(updatedUser.getLastName());
                            return true;
                        }
                ).orElse(false);
    }
}
