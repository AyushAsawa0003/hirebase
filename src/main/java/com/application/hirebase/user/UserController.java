package com.application.hirebase.user;


import com.application.hirebase.user.User;
import com.application.hirebase.user.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){

        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(users);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") int id){
        User user = userService.getUserByID(id);
        if(user == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        if(userService.addUser(user) != null){
         return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping(path = "/{id}")
    public void updateUserByID(@PathVariable("id") int id,  @RequestBody User user){
        userService.updateUserByID(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id")int id){
        User user = userService.deleteUserById(id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       return ResponseEntity.status(HttpStatus.OK).build();
    }


}
