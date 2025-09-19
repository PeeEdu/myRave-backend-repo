package com.my_rave.my_rave_backend.module.user.dto.response;

import java.util.UUID;

public record CreateAccountResponseDTO(
        String message,
        UUID id
) {
}
