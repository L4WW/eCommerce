package com.example.eCommerceDemo.business.abstracts;

import java.util.List;

import com.example.eCommerceDemo.business.requests.CreateProductRequest;
import com.example.eCommerceDemo.business.responses.GetAllProductsResponse;
import com.example.eCommerceDemo.business.responses.GetByIdProductResponse;



public interface ProductService {
	void add(CreateProductRequest createProductRequest);
	void delete(int id);
	List<GetAllProductsResponse> getAll();
	GetByIdProductResponse getById(int id);

}
