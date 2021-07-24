package com.sample.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="fruit")
public class Fruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="category")
	String Category;
	
	@Column(name="price")
	String price;
	
	@Builder
	public Fruit(int id, String name, String Category, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.Category = Category;
	}
}
