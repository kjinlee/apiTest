package com.sample.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.server.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

	List<Fruit> findAll();

	Fruit findByNameAndCategory(String name, String category);

}
