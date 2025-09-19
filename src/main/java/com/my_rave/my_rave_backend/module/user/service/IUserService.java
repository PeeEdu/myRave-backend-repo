package com.my_rave.my_rave_backend.module.user.service;

import com.my_rave.my_rave_backend.module.user.dto.request.CreateAccountRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.request.UserRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.response.CreateAccountResponseDTO;
import com.my_rave.my_rave_backend.module.user.dto.response.UserResponseDTO;

import java.util.UUID;

public interface IUserService {
    UserResponseDTO getUserById(UUID id);
    UserResponseDTO getUserByEmail(String email);
    String registerUser(CreateAccountRequestDTO userRequestDTO);
}
