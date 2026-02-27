package org.example.soaorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SoaOrderServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SoaOrderServiceApplication.class, args);
    }

}
