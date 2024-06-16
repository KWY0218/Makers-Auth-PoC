package org.example.platformback.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${jwt.secret}")
    private String secretKey;

    @GetMapping("/test")
    public String test() {
        return "platform server on";
    }

    @GetMapping("/secret")
    public ResponseEntity<String> secret() {
        System.out.println("secret key is " + secretKey);
        return ResponseEntity.ok("secret key is " + secretKey);
    }
}
