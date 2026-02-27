# 🚀 Java SOA / Microservices Project

A robust, distributed system built with **Java 17+** and **Spring Cloud**. This project demonstrates core patterns of Service-Oriented Architecture (SOA), including service discovery, declarative REST clients, fault tolerance, and centralized routing.

## 🏗️ Architecture Overview

The system consists of four main components:
* **Discovery Server (Eureka):** The central registry where all services identify themselves.
* **API Gateway:** The single entry point (Port 8080) that routes requests to internal services.
* **Order Service:** The consumer service that handles business logic and communicates with Inventory.
* **Inventory Service:** The provider service that manages product stock levels.

---

## 🛠️ Tech Stack

* **Framework:** Spring Boot 3.x
* **Service Discovery:** Netflix Eureka
* **API Gateway:** Spring Cloud Gateway
* **Client:** OpenFeign
* **Resilience:** Resilience4j (Circuit Breaker)
* **Build Tool:** Maven

---

## 📂 Service Breakdown

| Service Name | Port | Responsibility |
| :--- | :--- | :--- |
| `discovery-server` | `8761` | Service registration and lookup |
| `api-gateway` | `8080` | Routing and request filtering |
| `order-service` | `8082` | Order processing & stock validation |
| `inventory-service` | `8081` | Product catalog and stock management |

---

## 🚀 Getting Started

### Prerequisites
* JDK 17 or higher
* Maven 3.6+
* Your favorite IDE (IntelliJ, Eclipse, etc.)

### Installation & Running

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   ```

2. **Clean and Install:**

   ```Bash
   mvn clean install -U
   ```
3. **Run the services in this specific order:**

* Start discovery-service

* Start inventory-service

* Start order-service

* Start api-gateway

## 🧪 Testing the API

All requests should be sent through the API Gateway (8080).

### Check Inventory

**GET** http://localhost:8080/api/inventory/{productId}

### Place an Order

**POST** http://localhost:8080/api/orders/buy/{productId}
   
   <dd><b>💡 Pro Tip:</b> Stop the inventory-service while others are running to see the Circuit Breaker in action! The order-service will return a fallback message instead of an error.</dd>