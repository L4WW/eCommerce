package com.example.eCommerceDemo.business.requests;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
	@NotNull
	@NotBlank
	@Size(min=2,max=20)
	private String name;
	

}
