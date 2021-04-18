package com.mathew.java.springbootcrud.service;

import com.mathew.java.springbootcrud.model.Product;
import com.mathew.java.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product get(Integer productId) {
        Optional<Product> byId = productRepository.findById(productId);
        return byId.isPresent() ? byId.get() : null;
    }

    public  void delete(Integer productId){
        productRepository.deleteById(productId);
    }


}
