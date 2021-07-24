package com.my.shop.fruit.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.shop.fruit.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer>{
	
	List<Fruit> findAll();
	
	Fruit findByPrice(String name);

}
