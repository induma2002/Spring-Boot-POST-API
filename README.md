
# Product Management Application

This is a simple Spring Boot application that provides a RESTful API for managing products in a CRM system. It allows users to save product details including name, description, and price.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Features](#features)
- [Installation](#installation)
- [Usage and API Endpoints](#usage-and-api-endpoints)
- [Database Configuration](#database-configuration)
- [Project Structure](#project-structure)
- [Sample Code](#sample-code)
- [License](#license)

## Technologies Used

- Java 22
- Spring Boot 3.3.2
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Features

- Create and save products with details such as name, description, and price.
- RESTful API structure for easy integration with front-end applications.
- Database integration using JPA and MySQL.

## Installation

To set up the project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/product-manager.git
   ```
2. Navigate into the project directory:
   ```bash
   cd product-manager
   ```
3. Make sure you have Java 22 and Maven installed on your system.
4. Update the `application.yml` file with your MySQL database credentials.
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage and API Endpoints

You can use tools like Postman or cURL to interact with the API.

### Example of saving a product:

**POST** `/save-product`

**Request Body:**
```json
{
    "name": "Product Name",
    "description": "Product Description",
    "price": 99.99
}
```

### API Endpoints

| Method | Endpoint        | Description                       |
|--------|-----------------|-----------------------------------|
| POST   | `/save-product` | Save a new product to the database |

## Database Configuration

Make sure to configure your `application.yml` file for database connectivity. Below is a sample configuration:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/product_crm
    username: root
    password: 2004
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
```

## Project Structure

Here’s an overview of the project structure:

```
product-manager
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── edu
│   │   │       └── icet
│   │   │           └── crm
│   │   │               └── product
│   │   │                   ├── Application.java
│   │   │                   ├── controller
│   │   │                   │   └── ProductController.java
│   │   │                   ├── entity
│   │   │                   │   └── ProductEntity.java
│   │   │                   ├── model
│   │   │                   │   └── Product.java
│   │   │                   ├── repository
│   │   │                   │   └── ProductRepository.java
│   │   │                   ├── service
│   │   │                   │   ├── ProductService.java
│   │   │                   │   └── impl
│   │   │                   │       └── ProductServiceImpl.java
│   │   └── resources
│   │       └── application.yml
│   └── test
└── pom.xml
```

## Sample Code

Here’s a brief overview of the main classes in the project:

### ProductController.java

```java
package edu.icet.crm.product.controller;

import edu.icet.crm.product.model.Product;
import edu.icet.crm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/save-product")
    void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }
}
```

### ProductEntity.java

```java
package edu.icet.crm.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
}
```

### Product.java

```java
package edu.icet.crm.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private String name;
    private String description;
    private Double price;
}
```

### ProductRepository.java

```java
package edu.icet.crm.product.repository;

import edu.icet.crm.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    // CrudRepository interface has methods for CRUD operations
}
```

### ProductService.java

```java
package edu.icet.crm.product.service;

import edu.icet.crm.product.model.Product;

public interface ProductService {
    void saveProduct(Product product);
}
```

### ProductServiceImpl.java

```java
package edu.icet.crm.product.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.product.entity.ProductEntity;
import edu.icet.crm.product.model.Product;
import edu.icet.crm.product.repository.ProductRepository;
import edu.icet.crm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void saveProduct(Product product) {
        ProductEntity entity = objectMapper.convertValue(product, ProductEntity.class);
        productRepository.save(entity);
    }
}
```

### Application.java

```java
package edu.icet.crm.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

### Instructions

- Copy the entire content above into a file named `README.md`.
- Modify any sections as necessary, particularly the repository URL and license information.

This version includes the installation steps more clearly on a single page and maintains the overall structure and information.
