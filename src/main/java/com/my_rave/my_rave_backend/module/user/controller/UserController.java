package com.my_rave.my_rave_backend.module.user.controller;

import com.my_rave.my_rave_backend.global.DTO.ResponseDTO.BaseResponse;
import com.my_rave.my_rave_backend.module.user.dto.request.CreateAccountRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.request.UserRequestDTO;
import com.my_rave.my_rave_backend.module.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @Operation(summary = "Register a new user")
    public ResponseEntity<BaseResponse> createUser(@RequestBody CreateAccountRequestDTO user) {
        return ResponseEntity.ok(BaseResponse.builder()
                .message("User created successfully")
                .data(userService.registerUser(user))
                .build());
    }


}
