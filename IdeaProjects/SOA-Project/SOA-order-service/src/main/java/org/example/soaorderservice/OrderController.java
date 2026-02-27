package org.example.soaorderservice;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

//    private final RestTemplate restTemplate = new RestTemplate();

    private final RestTemplate restTemplate;
    private final InventoryClient inventoryClient;

    // Spring injects the @LoadBalanced bean here
    public OrderController(RestTemplate restTemplate, InventoryClient inventoryClient) {
        this.restTemplate = restTemplate;
        this.inventoryClient = inventoryClient;
    }
    // The URL of the Inventory Service
    //private final String INVENTORY_URL = "http://localhost:8081/inventory/";

    private final String INVENTORY_URL = "http://SOA-inventory-service/inventory/";

    @PostMapping("/buy/{productId}")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackInventory") // <--- Monitor this
    public String placeOrder(@PathVariable String productId) {

        // SOA IN ACTION:
        // 1. Order Service calls Inventory Service via network
//        StockResponse stock = restTemplate.getForObject(
//                INVENTORY_URL + productId,
//                StockResponse.class
//        );
        InventoryClient.StockResponse stock = inventoryClient.getStock(productId);

        // 2. Process business logic based on the response
        if (stock != null && stock.quantity() > 0) {
            return "Order confirmed for Product ID: " + productId;
        } else {
            return "Order failed! Product ID " + productId + " is out of stock.";
        }
    }
    // FALLBACK METHOD
    // Must have same signature as original method + Throwable
    public String fallbackInventory(String productId, Throwable t) {
        return "System is busy. Please try to order Product " + productId + " later.";
    }

    // Must match the structure of the response from Inventory Service
    public record StockResponse(String productId, int quantity) {}
}
