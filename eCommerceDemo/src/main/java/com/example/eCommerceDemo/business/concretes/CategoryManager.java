package com.example.eCommerceDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.eCommerceDemo.business.abstracts.CategoryService;
import com.example.eCommerceDemo.business.requests.CreateCategoryRequest;
import com.example.eCommerceDemo.business.responses.GetAllCategoriesResponse;
import com.example.eCommerceDemo.business.responses.GetByIdCategoryResponse;
import com.example.eCommerceDemo.core.utilities.mappers.ModelMapperService;
import com.example.eCommerceDemo.dataAccess.abstracts.CategoryRepository;
import com.example.eCommerceDemo.entities.concretes.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
	private final ModelMapperService modelMapperService;
	private final CategoryRepository categoryRepository;

	@Override
	public void delete(int id) {
		this.categoryRepository.deleteById(id);
		
	}

	@Override
	public List<GetAllCategoriesResponse> getAll() {
		List<Category> categories = this.categoryRepository.findAll();
		
		List<GetAllCategoriesResponse> response = categories.stream()
				.map(category->this.modelMapperService.forResponse()
						.map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());
		
		return response;
	}

	@Override
	public GetByIdCategoryResponse getById(int id) {
		Category category=this.categoryRepository.findById(id).orElseThrow();
		GetByIdCategoryResponse response = this.modelMapperService.forResponse().map(category, GetByIdCategoryResponse.class);
		return response;
	}

	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		category.setId(0);
		this.categoryRepository.save(category);
	}

}