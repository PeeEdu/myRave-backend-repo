package com.my_rave.my_rave_backend.module.user.service;

import com.my_rave.my_rave_backend.module.user.database.model.User;
import com.my_rave.my_rave_backend.module.user.database.service.IUserDatabaseService;
import com.my_rave.my_rave_backend.module.user.dto.request.CreateAccountRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.request.UserRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.response.UserResponseDTO;
import com.my_rave.my_rave_backend.module.user.entity.UserEntity;
import com.my_rave.my_rave_backend.module.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final IUserDatabaseService userDatabaseService;

    public UserService(IUserDatabaseService userDatabaseService) {
        this.userDatabaseService = userDatabaseService;
    }

    @Override
    public UserResponseDTO getUserById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        try {
            userDatabaseService.getUserById(id);
            return UserMapper.toUserResponseDTO(userDatabaseService.getUserById(id));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        try {
            userDatabaseService.getUserByEmail(email);
            return UserMapper.toUserResponseDTO(userDatabaseService.getUserByEmail(email));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String registerUser(CreateAccountRequestDTO createAccountRequestDTO) {
        boolean existsUser = verifyUser(createAccountRequestDTO.email());
        if (existsUser) {
            throw new IllegalArgumentException("User already exists");
        }

        UserEntity userEntity = UserMapper.toUserEntity(createAccountRequestDTO);
        userEntity.setCreatedAt(LocalDate.now());


        userDatabaseService.saveUser(UserMapper.toUser(userEntity));
        return "Created";
    }


    public boolean verifyUser(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        // Verifica se o usuário com o email fornecido existe
        User user = userDatabaseService.getUserByEmail(email);
        return user == null; // Retorna true se o email estiver disponível (não existir)
    }
}
