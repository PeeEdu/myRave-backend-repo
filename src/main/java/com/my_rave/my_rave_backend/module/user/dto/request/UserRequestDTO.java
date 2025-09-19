package com.my_rave.my_rave_backend.module.user.dto.request;

import com.my_rave.my_rave_backend.module.user.database.model.UserInterest;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record UserRequestDTO(
        String name,
        String email,
        String cpf,
        char gender,
        LocalDate bornDate,
        String password,
        Set<UserInterest> interests
) {
}
