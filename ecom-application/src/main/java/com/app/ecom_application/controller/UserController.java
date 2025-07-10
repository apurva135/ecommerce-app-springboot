package com.app.ecom_application.controller;



import com.app.ecom_application.model.User;
import com.app.ecom_application.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

   private final UserService service;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUser (){
        List<User> user = service.fetchUser();
        if(user == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);

    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {

//       Optional<User> user = service.fetchUser(id);
//       if(user == null)
//       {
//           return ResponseEntity.notFound().build();
//       }
//       return ResponseEntity.ok(user);

        return service.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/add")
    public String createuser(@RequestBody User user)
    {
        service.addUser(user);
        return "added";
    }

    @PutMapping("/api/update/{id}")
    public ResponseEntity<String> updateUser (@PathVariable Long id, @RequestBody User updated)
    {
        boolean update  = service.updateUser(id,updated);
        if(update)
        {
            return ResponseEntity.ok("User added successfully");
        }
        return  ResponseEntity.notFound().build();
    }

}
