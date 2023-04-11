package com.example.eCommerceDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eCommerceDemo.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
