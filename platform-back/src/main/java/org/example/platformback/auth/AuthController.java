package org.example.platformback.auth;

import lombok.RequiredArgsConstructor;
import org.example.platformback.auth.dto.request.AuthReqDto;
import org.example.platformback.auth.dto.response.TokenResDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/authorize")
    public ResponseEntity<String> authorizeCode(
            @RequestParam("code") String code,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_url") String redirectUrl
    ) throws URISyntaxException {
        Long userId = authService.getUserId(code);
        if (userId == null) return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("존재하지 않는 유저입니다.");

        return ResponseEntity
                .status(302)
                .contentType(MediaType.APPLICATION_JSON)
                .location(new URI(redirectUrl + "?code=PlatformAuthorizeCode"))
                .build();
    }

    @PostMapping(
            path = "/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public ResponseEntity<TokenResDto> token(
            AuthReqDto data
    ) {
        System.out.println(data);
        String grantType = data.grantType();
        System.out.println(grantType);
        assert grantType != null;
        if (!grantType.equals("authorizationCode")) return ResponseEntity.badRequest().build();
        System.out.println("return after");

        return ResponseEntity
                .ok(new TokenResDto("access token", "refresh token"));
    }
}
