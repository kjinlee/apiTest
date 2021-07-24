package com.sample.server.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.server.config.CookieUtil;
import com.sample.server.config.JwtTokenProvider;
import com.sample.server.model.Fruit;
import com.sample.server.model.Response;
import com.sample.server.model.User;
import com.sample.server.model.UserResponse;
import com.sample.server.service.FruitService;


@RestController
public class FruitController {
	
	@Autowired
	private JwtTokenProvider jwtProvider;
	
	@Autowired
	private CookieUtil cookieUtil;
	
	@Autowired
	private FruitService service;
	
	 
	 @PostMapping("/token")
	 public Response login(@RequestParam String name, HttpServletRequest req, HttpServletResponse res) {
		 try {
			 final String token = jwtProvider.createToken(name,"USER");
			 Cookie accessToken = cookieUtil.createCookie(jwtProvider.ACCESS_TOKEN_NAME, token);
			 res.addCookie(accessToken);
			 
			 return new Response("success", "완료.", token);
		 } catch (Exception e) {
			 return new Response("error", "토큰이 필요합니다.", e.getMessage());
		 }
	 }
	 

    @GetMapping(value = "/product")
    public List<Fruit> getFruit(){
    	
    	
       return service.findAll();
    }
    
  
    
	

}
