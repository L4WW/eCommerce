package com.example.eCommerceDemo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
@Entity
public class Product {
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="product_name")
	private String name;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	 

}
