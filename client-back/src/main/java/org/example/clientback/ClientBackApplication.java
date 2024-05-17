package org.example.clientback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ClientBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientBackApplication.class, args);
    }

}
