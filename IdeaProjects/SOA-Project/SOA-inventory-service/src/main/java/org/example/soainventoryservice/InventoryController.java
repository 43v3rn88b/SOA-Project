package org.example.soainventoryservice;


import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    // Simulating a database with a Map
    // ID 1 = Laptop, ID 2 = Phone
    private final Map<String, Integer> productStock = Map.of(
            "1", 100, // 100 Laptops available
            "2", 0    // 0 Phones available (Out of Stock)
    );

    @GetMapping("/{productId}")
    public StockResponse getStock(@PathVariable String productId) {
        Integer quantity = productStock.getOrDefault(productId, 0);
        return new StockResponse(productId, quantity);
    }

    // Simple DTO (Data Transfer Object)
    public record StockResponse(String productId, int quantity) {}
}
