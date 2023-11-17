package com.javaexpress.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javaexpress.models.Product;

@RestController
@RequestMapping("restTemplateApi")
public class RestTemplateController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/template/getproductbyid/{id}")
	public Product getProductById(@PathVariable("id") Integer id) {

		String end_point = "http://localhost:9090/api/v1/product/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(end_point, HttpMethod.GET, entity, Product.class).getBody();
	}

	@GetMapping(value = "/template/getallproducts")
	public List<Product> getAllProducts() {

		String end_point = "http://localhost:9090/api/v1/product";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		Product[] productArray = restTemplate.exchange(end_point, HttpMethod.GET, null, Product[].class).getBody();

		return Arrays.asList(productArray);
	}

	@PostMapping(value = "/template/createProduct")
	public Product createProduct(@RequestBody Product product) {

		String end_point = "http://localhost:9090/api/v1/product";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange(end_point, HttpMethod.POST, entity, Product.class).getBody();
	}

	@PutMapping(value = "/template/updateProduct/{id}")
	public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {

		String end_point = "http://localhost:9090/api/v1/product";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange(end_point, HttpMethod.PUT, entity, Product.class).getBody();
	}

	@DeleteMapping(value = "/template/deleteProduct/{id}")
	public Boolean deleteProduct(@PathVariable("id") Integer id) {

		String end_point = "http://localhost:9090/api/v1/product/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		ResponseEntity<Boolean> exchange = restTemplate.exchange(end_point, HttpMethod.DELETE, entity, Boolean.class);

		if (exchange.getStatusCode().equals(200)) {
			return true;
		} else {
			return false;
		}
	}
}
