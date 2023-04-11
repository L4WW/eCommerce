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

import com.example.eCommerceDemo.business.abstracts.CategoryService;
import com.example.eCommerceDemo.business.requests.CreateCategoryRequest;
import com.example.eCommerceDemo.business.responses.GetAllCategoriesResponse;
import com.example.eCommerceDemo.business.responses.GetByIdCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@CrossOrigin
public class CategoriesController {
	private CategoryService categoryService;
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
		this.categoryService.add(createCategoryRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.categoryService.delete(id);
	}
	@GetMapping("/getall")
	public List<GetAllCategoriesResponse> getAll() {
		
		return categoryService.getAll();
		
	}
	@GetMapping("/{id}")
	public GetByIdCategoryResponse getById(@PathVariable int id) {
		
		return this.categoryService.getById(id);
	}
	

}
