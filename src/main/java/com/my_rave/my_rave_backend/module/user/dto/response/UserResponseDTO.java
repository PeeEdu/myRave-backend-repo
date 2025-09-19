package com.my_rave.my_rave_backend.module.user.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        char gender,
        LocalDate bornDate,
        LocalDate createdAt,
        LocalDate updatedAt
) {
}
