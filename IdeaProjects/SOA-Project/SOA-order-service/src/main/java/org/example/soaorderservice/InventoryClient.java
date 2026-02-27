package org.example.soaorderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "name" must match the spring.application.name of the Inventory Service
@FeignClient(name = "SOA-inventory-service")
public interface InventoryClient {

    // This signature must match the Controller in Inventory Service
    @GetMapping("/inventory/{productId}")
    StockResponse getStock(@PathVariable("productId") String productId);

    // Re-declare the DTO here so Feign knows what to map the JSON to
    record StockResponse(String productId, int quantity) {}
}
