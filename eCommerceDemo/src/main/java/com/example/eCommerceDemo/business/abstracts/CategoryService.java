package com.example.eCommerceDemo.business.abstracts;

import java.util.List;

import com.example.eCommerceDemo.business.requests.CreateCategoryRequest;
import com.example.eCommerceDemo.business.responses.GetAllCategoriesResponse;
import com.example.eCommerceDemo.business.responses.GetByIdCategoryResponse;



public interface CategoryService {
	void add(CreateCategoryRequest createCategoryRequest);
	void delete(int id);
	List<GetAllCategoriesResponse> getAll();
	GetByIdCategoryResponse getById(int id);

}
