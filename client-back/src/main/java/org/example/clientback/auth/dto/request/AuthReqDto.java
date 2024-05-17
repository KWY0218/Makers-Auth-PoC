package org.example.clientback.auth.dto.request;

public record AuthReqDto(
        String grantType,
        String clientId,
        String redirectUri,
        String code
) {
}
