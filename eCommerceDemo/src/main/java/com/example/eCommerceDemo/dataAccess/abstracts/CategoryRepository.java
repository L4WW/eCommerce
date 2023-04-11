package com.example.eCommerceDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eCommerceDemo.entities.concretes.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
