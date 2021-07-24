package com.my.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.client.model.Fruit;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Arrays;


@RestController
public class FruitController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FruitController.class);

    @GetMapping(value="/getList")
    public ModelAndView getFruitList(){
        return new ModelAndView("getList");
    }

    @RequestMapping(value = "/showList", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("code") String code)throws JsonProcessingException, IOException {
        ResponseEntity<String> response = null;
        LOGGER.info("Authorization Code======>{}", code);

        RestTemplate restTemplate = new RestTemplate();

        String credentials = "client:secret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + encodedCredentials);

        HttpEntity<String> request = new HttpEntity<String>(headers);

        String access_token_url = "http://localhost:8080/oauth/token";
        access_token_url += "?code=" + code;
        access_token_url += "&grant_type=authorization_code";
        access_token_url += "&redirect_uri=http://localhost:8090/showList";

        response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

        LOGGER.info("Access Token Response======>{}", response.getBody());

        // Get the Access Token From the recieved JSON response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.getBody());
        String token = node.path("access_token").asText();

        String url = "http://localhost:8080/product";

        // Use the access token for authentication
        HttpHeaders headers1 = new HttpHeaders();
        headers1.add("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers1);

        ResponseEntity<Fruit[]> fruitList = restTemplate.exchange(url, HttpMethod.GET, entity, Fruit[].class);
        System.out.println(fruitList);
        Fruit[] fruitArray = fruitList.getBody();

        ModelAndView model = new ModelAndView("showList");
        model.addObject("fruitList", Arrays.asList(fruitArray));
        return model;
    }
}
