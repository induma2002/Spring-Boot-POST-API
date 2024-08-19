package edu.icet.crm.product.sevice.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.product.entity.ProductEntity;
import edu.icet.crm.product.model.Product;
import edu.icet.crm.product.repository.ProductRepository;
import edu.icet.crm.product.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;        //we creat ob in product repository but it has not ob because that is an interface

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void saveProduct(Product product) {
        ProductEntity entity = objectMapper.convertValue(product, ProductEntity.class);
        productRepository.save(entity);
    }
}
