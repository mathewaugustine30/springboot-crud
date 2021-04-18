package com.mathew.java.springbootcrud.web;


import com.mathew.java.springbootcrud.model.Product;
import com.mathew.java.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/old")
public class ProductControllerV1 {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product get(@PathVariable Integer prodId){
        return productService.get(prodId);
    }

    @DeleteMapping("/products/{prodId}")
    public void delete(@PathVariable Integer prodId){
        productService.delete(prodId);
    }
    @PostMapping("/products")
    public void add(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("/products/{prodId}")
    public void update(@RequestBody Product product,@PathVariable Integer prodId){
        Product existingProduct =productService.get(prodId);
        productService.save(product);
    }


}
