package org.example.platformback.auth;

import lombok.RequiredArgsConstructor;
import org.example.platformback.auth.dto.request.AuthReqDto;
import org.example.platformback.auth.dto.response.TokenResDto;
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

    // http://localhost:8080/authorize?code=1234&client_id=client_id&redirect_url=http://localhost:3000/login
    @GetMapping("/authorize")
    public ResponseEntity<String> authorizeCode(
            @RequestParam("code") String code,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_url") String redirectUrl
    ) throws URISyntaxException {
        Long userId = authService.getUserId(code);
        if (userId == null) return ResponseEntity
                .notFound()
                .build();

        return ResponseEntity
                .status(302)
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
        String grantType = data.grantType();
        assert grantType != null;
        if (!grantType.equals("authorizationCode")) return ResponseEntity.badRequest().build();

        return ResponseEntity
                .ok(new TokenResDto("access token", "refresh token"));
    }
}
