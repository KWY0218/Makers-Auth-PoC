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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/authorize")
    public ResponseEntity<TokenResDto> authorizeCode(
            @RequestParam("grantType") String grantType,
            @RequestParam("code") String code,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_url") String redirectUrl
    ) {
        TokenResDto response = getToken(new AuthReqDto(grantType, code, clientId, redirectUrl));
        if (response == null) return ResponseEntity.badRequest().build();
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

        try {
            return restTemplate.postForObject("http://platform-back:8080/token", entity, TokenResDto.class);
        } catch (Exception e) {
            System.out.println("error is " + e.getMessage());
            return null;
        }
    }
}
