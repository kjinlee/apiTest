package com.my.shop.fruit.controller;

import com.my.shop.fruit.model.Fruit;
import com.my.shop.fruit.service.FruitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {

	@Autowired
	FruitService service;

    @GetMapping(value = "/product")
    public List<Fruit> getFruit(){
       return service.findAll();
    }
}
