package com.mathew.java.springbootcrud.repository;

import com.mathew.java.springbootcrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
