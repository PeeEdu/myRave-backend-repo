package com.my_rave.my_rave_backend.module.user.mapper;

import com.my_rave.my_rave_backend.module.user.database.model.User;
import com.my_rave.my_rave_backend.module.user.dto.request.CreateAccountRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.request.UserRequestDTO;
import com.my_rave.my_rave_backend.module.user.dto.response.UserResponseDTO;
import com.my_rave.my_rave_backend.module.user.entity.UserEntity;


public class UserMapper {
    public static UserResponseDTO toUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender())
                .bornDate(user.getBornDate())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public static UserEntity toUserEntity(UserRequestDTO userRequestDTO) {
        return UserEntity.builder()
                .name(userRequestDTO.name())
                .email(userRequestDTO.email())
                .cpf(userRequestDTO.cpf())
                .gender(userRequestDTO.gender())
                .bornDate(userRequestDTO.bornDate())
                .password(userRequestDTO.password())
                .build();
    }
    public static User toUser(UserRequestDTO userRequestDTO) {
        return User.builder()
                .name(userRequestDTO.name())
                .email(userRequestDTO.email())
                .gender(userRequestDTO.gender())
                .bornDate(userRequestDTO.bornDate())
                .build();
    }

    public static User toUser(UserEntity userEntity) {
        return User.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .gender(userEntity.getGender())
                .bornDate(userEntity.getBornDate())
                .build();
    }

    public static UserEntity toUserEntity(CreateAccountRequestDTO createAccountRequestDTO) {
        return UserEntity.builder()
                .name(createAccountRequestDTO.name())
                .email(createAccountRequestDTO.email())
                .cpf(createAccountRequestDTO.cpf())
                .gender(createAccountRequestDTO.gender())
                .bornDate(createAccountRequestDTO.bornDate())
                .password(createAccountRequestDTO.password())
                .build();
    }
}
