package com.link.rider.dto;

public record UserResponse(
        Long id,
        String username,
        String fullName,
        String phone
) {
}
