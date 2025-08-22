package com.my_rave.my_rave_backend.module.user.controller;

import com.my_rave.my_rave_backend.module.user.database.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok("Ok");
    }

}
