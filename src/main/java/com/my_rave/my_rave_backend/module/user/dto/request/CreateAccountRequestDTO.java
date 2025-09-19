package com.my_rave.my_rave_backend.module.user.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateAccountRequestDTO(
        String name,
        String email,
        String cpf,
        char gender,
        LocalDate bornDate,
        String password
) {
}
