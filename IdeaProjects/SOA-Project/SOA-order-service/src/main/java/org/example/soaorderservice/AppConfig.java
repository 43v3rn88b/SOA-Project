package org.example.soaorderservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced // <--- Crucial! Tells Spring to look up names in Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
