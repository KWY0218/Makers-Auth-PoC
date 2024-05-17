package org.example.platformback.auth.dto.request;

public record AuthReqDto(
        String grantType,
        String clientId,
        String redirectUri,
        String code,
        String refreshToken
) {
}
