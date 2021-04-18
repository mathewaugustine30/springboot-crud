package com.mathew.java.springbootcrud.web;

import com.mathew.java.springbootcrud.model.Product;
import com.mathew.java.springbootcrud.service.ProductService;
import com.mathew.java.springbootcrud.web.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) throws ProductNotFoundException {
        final Product product = productService.get(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            throw ProductNotFoundException.createWith(id);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Integer id) throws ProductNotFoundException {
        Product existingProduct = productService.get(id);
        if (existingProduct != null) {
            productService.save(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            throw ProductNotFoundException.createWith(id);
        }

    }


}
