package com.example.eCommerceDemo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProductResponse {
	private int id;
	private String name;
	private double unitPrice;
	private short unitsInStock;
	private String categoryName;
}
