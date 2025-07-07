package com.app.ecom_application;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public User fetchUser(Long id)
    {
        for(User user:userList)
        {
            if(user.getId().equals(id))
            {
                return user;
            }
        }
        return null;
    }
}
