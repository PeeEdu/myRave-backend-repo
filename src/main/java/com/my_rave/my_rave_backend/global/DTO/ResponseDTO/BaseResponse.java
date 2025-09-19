package com.my_rave.my_rave_backend.global.DTO.ResponseDTO;

import lombok.Builder;

@Builder
public record BaseResponse(
        String message,
        int statusCode,
        Object data
) {
}
