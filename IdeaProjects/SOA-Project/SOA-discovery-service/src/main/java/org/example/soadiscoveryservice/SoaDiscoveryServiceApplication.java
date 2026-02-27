package org.example.soadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SoaDiscoveryServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SoaDiscoveryServiceApplication.class, args);
    }

}
