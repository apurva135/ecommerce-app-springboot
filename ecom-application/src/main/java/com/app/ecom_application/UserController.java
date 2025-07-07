package com.app.ecom_application;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

   private final UserService service;

    @GetMapping("/api/users")
    public List<User> getAllUser (){
       return service.fetchUser();
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {

       User user = service.fetchUser(id);
       if(user == null)
       {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(user);
    }

    @PostMapping("/api/add")
    public String createuser(@RequestBody User user)
    {
        service.addUser(user);
        return "added";
    }

}
