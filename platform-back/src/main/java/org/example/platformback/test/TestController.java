package org.example.platformback.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private String secretKey = "asd";

    @GetMapping("/test")
    public String test() {
        return "platform server on";
    }

    @GetMapping("/secret")
    public ResponseEntity<String> secret() {
        return ResponseEntity.ok("secret key is " + secretKey);
    }
}
