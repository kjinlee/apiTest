package com.my.shop.fruit.service;

import com.my.shop.fruit.model.Fruit;
import com.my.shop.fruit.repository.FruitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    
}
