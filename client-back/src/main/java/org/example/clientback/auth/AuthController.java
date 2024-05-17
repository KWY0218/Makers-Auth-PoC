package org.example.clientback.auth;

import lombok.RequiredArgsConstructor;
import org.example.clientback.auth.dto.request.AuthReqDto;
import org.example.clientback.auth.dto.response.TokenResDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public ResponseEntity<TokenResDto> token(AuthReqDto data) {
        TokenResDto response = getToken(data);
        return ResponseEntity
                .ok(response);
    }

    private TokenResDto getToken(AuthReqDto data) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("grantType", data.grantType());
        parameters.add("code", data.code());
        parameters.add("clientId", data.clientId());
        parameters.add("redirectUri", data.redirectUri());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(parameters, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8080/token", entity, TokenResDto.class);
    }
}
