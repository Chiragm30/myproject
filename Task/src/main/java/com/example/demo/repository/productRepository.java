package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Product;

@Repository
public interface productRepository extends JpaRepository<Product,Integer> {

	public Product findByproname(String proname);
}
