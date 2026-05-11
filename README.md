# Order Processing System

Asynchronous order processing system built with Java, Spring Boot, Kafka, and PostgreSQL.

## Technologies

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Apache Kafka
* Docker
* Gradle

---

# Architecture

The application follows a layered architecture with:

* Controllers (HTTP API)
* Application Services / Use Cases
* Domain Layer
* Kafka Producers & Consumers
* PostgreSQL Persistence

The system processes orders asynchronously using Kafka events.

---

# Features

## Order Creation

* Create orders with multiple items
* Validate:

    * Product existence
    * Active products
    * Quantity rules
* Persist orders and items in PostgreSQL
* Publish `OrderCreated` event to Kafka

---

## Asynchronous Order Processing

Kafka consumer listens to `OrderCreated` events and performs:

### Global Validations

* High-value order validation
* Mock payment processing
* Fraud validation simulation

### Item Processing by Product Type

Implemented architecture for:

* PHYSICAL
* DIGITAL
* SUBSCRIPTION
* PRE_ORDER
* CORPORATE

Validation strategy is separated by product type using dedicated services.

### Status Management

Order statuses:

* PENDING
* PROCESSING
* PROCESSED
* FAILED
* PENDING_APPROVAL

### Event Publishing

The system publishes processing result events:

* `OrderProcessed`
* `OrderFailed`
* `OrderPendingApproval`
* `LowStockAlert`
* `FraudAlert`

---

# Running the Project

## Requirements

* Docker
* Docker Compose
* Java 17

---

# Start Infrastructure

```bash
make up
```

This starts:

* PostgreSQL
* Kafka
* Zookeeper
* Kafka UI

---

# Run Application

```bash
make run
```

---

# Run Tests

```bash
make test
```

---

# Kafka UI

Kafka UI is available at:

```text
http://localhost:8085
```

---

# Main Kafka Topics

* `order-created`
* `order-processed`
* `order-failed`
* `order-pending-approval`
* `low-stock-alert`
* `fraud-alert`

---

# API Example

## Create Order

```http
POST /orders
```

Example request:

```json
{
  "customerId": 23,
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

---

# Project Status

Implemented:

* Order creation
* Order persistence
* Kafka producer
* Kafka consumer
* Async processing flow
* Global validations
* Validation strategy architecture by product type
* Status update flow
* Event publishing structure

Pending improvements:

* Complete item-specific validation rules
* Additional automated tests
* Retry strategies
* Advanced transaction handling
* Dead Letter Queue (DLQ)

---

# Author

Developed as a backend engineering challenge project.
