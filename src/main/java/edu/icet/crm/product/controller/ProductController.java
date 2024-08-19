package edu.icet.crm.product.controller;

import edu.icet.crm.product.model.Product;

import edu.icet.crm.product.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController // Add as a controller
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/save-product") // Make post request from frontend
    void saveProduct(@RequestBody Product product) {        // Map browser request json ob to java ob using "@RequestBody"

        service.saveProduct(product);
    }

}
