package com.sample.server.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sample.server.model.Fruit;
import com.sample.server.service.FruitService;


@RestController
public class FruitController {
	
	@Autowired
	private FruitService service;
	
	
	@GetMapping(value="/")
	public ModelAndView home() {
		
		return new ModelAndView("show");
	}
	
    @GetMapping(value = "/list")
    public List<Fruit> getFruit(){
       return service.findAll();
    }
    
	@GetMapping(value = "/get")
    public String getPrice(@RequestParam String name, String category,Model model) {
    	Fruit fruit = service.findByNameAndCategory(name, category);
    	
    	if(fruit != null) {
    		
    		return fruit.getPrice();
    	}
    	
    	return null;
    }
    
//    @GetMapping(value = "/get")
//    public ModelAndView getPrice(@RequestParam String name, String category,Model model) {
//    	Fruit fruit = service.findByNameAndCategory(name, category);
//    	
//    	if(fruit != null) {
//    		
//    		model.addAttribute("fruit", fruit);
//    		
//    		return new ModelAndView("result");
//    	}
//    	
//    	return new ModelAndView("show");
//    }
    
    
	

}
