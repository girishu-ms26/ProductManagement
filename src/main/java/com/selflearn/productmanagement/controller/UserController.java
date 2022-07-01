package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.User;
import com.selflearn.productmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/userRegister")
    public ResponseEntity userRegister(@RequestBody User newUser) {
        return userService.userRegister(newUser);
    }

    @PostMapping("/userSignin")
    public ResponseEntity userSignIn(@RequestBody User user) {
        return userService.userSignIn(user);
    }
}
