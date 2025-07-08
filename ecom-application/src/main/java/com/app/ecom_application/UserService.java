package com.app.ecom_application;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    List<User> userList = new ArrayList<>();

    public List<User> fetchUser()
    {
        return userList;
    }

    public List<User> addUser(User user)
    {
        userList.add(user);
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
