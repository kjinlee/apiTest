package com.sample.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.server.model.Fruit;
import com.sample.server.repository.FruitRepository;

@Service
public class FruitService {
	
	@Autowired
	FruitRepository fruitRepository;

	public List<Fruit> findAll() {
		List<Fruit> list = fruitRepository.findAll();

		for (Fruit fruit : list) {
			System.out.println(fruit.toString());
		}

		return list;
	}
	
	public Fruit findByNameAndCategory(String name, String category) {
		return fruitRepository.findByNameAndCategory(name, category);
	}


    
}
