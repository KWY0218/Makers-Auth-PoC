package org.example.platformback.auth;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {
    private final ConcurrentHashMap<String, Long> db = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        db.put("1234", 1L);
    }

    public Long getUserId(String socialId) {
        return db.get(socialId);
    }
}
