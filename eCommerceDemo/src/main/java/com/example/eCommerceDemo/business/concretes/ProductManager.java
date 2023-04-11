package com.example.eCommerceDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.eCommerceDemo.business.abstracts.ProductService;
import com.example.eCommerceDemo.business.requests.CreateProductRequest;
import com.example.eCommerceDemo.business.responses.GetAllProductsResponse;
import com.example.eCommerceDemo.business.responses.GetByIdProductResponse;
import com.example.eCommerceDemo.core.utilities.mappers.ModelMapperService;
import com.example.eCommerceDemo.dataAccess.abstracts.ProductRepository;
import com.example.eCommerceDemo.entities.concretes.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
	private ModelMapperService modelMapperService;
	private ProductRepository productRepository;
	@Override
	public void add(CreateProductRequest createProductRequest) {
		
		Product product= this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		product.setId(0);
		this.productRepository.save(product);
	}

	@Override
	public void delete(int id) {
		this.productRepository.deleteById(id);
		
	}

	@Override
	public List<GetAllProductsResponse> getAll() {
		List<Product> products = this.productRepository.findAll();
		
		List<GetAllProductsResponse> response = products.stream()
				.map(product->this.modelMapperService.forResponse()
						.map(product, GetAllProductsResponse.class)).collect(Collectors.toList());
		
		return response;
	}

	@Override
	public GetByIdProductResponse getById(int id) {
		Product product=this.productRepository.findById(id).orElseThrow();
		GetByIdProductResponse response = this.modelMapperService.forResponse().map(product, GetByIdProductResponse.class);
		return response;
	}

}