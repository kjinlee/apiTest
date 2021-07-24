package com.sample.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.server.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer>{
	
	List<Fruit> findAll();
	
	Fruit findByPrice(String name);

}
