package com.example.eCommerceDemo.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerceDemo.business.abstracts.ProductService;
import com.example.eCommerceDemo.business.requests.CreateProductRequest;
import com.example.eCommerceDemo.business.responses.GetAllProductsResponse;
import com.example.eCommerceDemo.business.responses.GetByIdProductResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@CrossOrigin
public class ProductsController {
	private ProductService productService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid @RequestBody CreateProductRequest createProductRequest) {
		this.productService.add(createProductRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.productService.delete(id);
	}
	@GetMapping("/getall")
	public List<GetAllProductsResponse> getAll() {
		
		return productService.getAll();
		
	}
	@GetMapping("/{id}")
	public GetByIdProductResponse getById(@PathVariable int id) {
		
		return this.productService.getById(id);
	}

}
