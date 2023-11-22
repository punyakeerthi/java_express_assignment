package com.javaexpress.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.models.Product;
import com.javaexpress.service.ProductService;
import com.javaexpress.service.responses.ProductBoResponse;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping(value = "/pagination")
	public ProductBoResponse fetchProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "noOfRecords", required = false, defaultValue = "3") int noOfRecords,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC") String sort) {
		if (sort.equals("ASC")) {
			return productService.fetchProductsUsingPagination(
					PageRequest.of(pageNumber, noOfRecords, Direction.ASC, new String[] { "price", "name" }));
		} else {
			return productService.fetchProductsUsingPagination(
					PageRequest.of(pageNumber, noOfRecords, Direction.DESC, new String[] { "price", "name" }));
		}
	}
	// http://localhost:8080/api/v1/product/pagination

	// http://localhost:8080/api/v1/product/pagination?pageNumber=3

	// http://localhost:8080/api/v1/product/pagination?noOfRecords=7

	// http://localhost:8080/api/v1/product/pagination?sort=ASC

	// http://localhost:8080/api/v1/product/pagination?noOfRecords=7&pageNumber=2&sort=DESC

	// // http://localhost:8080/api/v1/product/pagination?noOfRecords=7&sort=DESC

	@GetMapping("/name/{pname}")
	public Product fetchProduct(@PathVariable("pname") String name) {
		return productService.fetchProduct(name);
	}

	@GetMapping("/price/{pprice}")
	public Product fetchProduct(@PathVariable("pprice") double price) {
		return productService.fetchProductUsingPrice(price);
	}

	@GetMapping
	public List<Product> fetchAllProducts() {
		return productService.fetchAllProducts();
	}

	@GetMapping(value = "/{id}")
	public Product fetchProduct(@PathVariable("id") Integer productId) {
		Optional<Product> fetchProduct = productService.fetchProduct(productId);

		if (fetchProduct.get() != null) {
			return fetchProduct.get();
		} else {
			return null;
		}
	}

	@GetMapping(value = "/productId")
	public Product fetchProduct1(@RequestParam("id") Integer productId) {
		Optional<Product> fetchProduct = productService.fetchProduct(productId);

		if (fetchProduct.get() != null) {
			return fetchProduct.get();
		} else {
			return null;
		}
	}

	// pagination - RequestParam

	// id and name
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer productId) {
		productService.deleteProductById(productId);
	}

	@DeleteMapping
	public void deleteAllProducts() {
		productService.deleteAllProducts();
	}

	@GetMapping("/fetchProductByNameAndPrice/{pprice}/{pname}")
	public Product fetchByNameAndPrice(@PathVariable("pprice") double price, @PathVariable("pname") String name) {
		return productService.fetchProductUsingNameAndPrice(name, price);
	}

	@GetMapping("/fetchProductByNameOrPrice")
	public Product fetchProductByNameOrPrice(@RequestParam("pprice") double price, @RequestParam("pname") String name) {
		return productService.fetchProductByNameOrPrice(name, price);
	}

	@GetMapping("/fetchProductByPriceLessThan/{pprice}")
	public List<Product> fetchProductByPriceLessThan(@PathVariable("pprice") double price) {
		return productService.fetchProductByPriceLessThan(price);
	}

	@GetMapping("/fetchProductByPriceGreaterThan/{pprice}")
	public List<Product> fetchProductByPriceGreaterThan(@PathVariable("pprice") double price) {
		return productService.fetchProductByPriceGreaterThan(price);
	}

	@GetMapping("/fetchProductByPriceOrderByNameAsc/{pprice}")
	public List<Product> fetchProductByPriceOrderByNameAsc(@PathVariable("pprice") double price) {
		return productService.fetchProductByPriceOrderByNameAsc(price);
	}

	@GetMapping("/fetchProductByPriceOrderByNameDesc/{pprice}")
	public List<Product> fetchProductByPriceOrderByNameDesc(@PathVariable("pprice") double price) {
		return productService.fetchProductByPriceOrderByNameDesc(price);
	}

	@GetMapping("/fetchProductByActiveTrue")
	public List<Product> fetchProductByActiveTrue() {
		return productService.fetchProductByActiveTrue();
	}

	@GetMapping("/fetchProductByActiveFalse")
	public List<Product> fetchProductByActiveFalse() {
		return productService.fetchProductByActiveFalse();
	}

	@GetMapping("/fetchProductByActive/{status}")
	public List<Product> fetchProductByActive(@PathVariable("status") boolean status) {
		return productService.fetchProductByActive(status);
	}

	@GetMapping("/fetchProductByCategoryName/{cname}")
	public List<Product> fetchProductByCategoryName(@PathVariable("cname") String cname) {
		return productService.fetchProductByCategoryName(cname);
	}

	@GetMapping("/fetchProductByNameContaining/{pname}")
	public List<Product> fetchProductByNameContaining(@PathVariable("pname") String pname) {
		return productService.fetchProductByNameContaining(pname);
	}

	@GetMapping("/fetchAllProductsUsingJPQL")
	public List<Product> fetchAllProductsUsingJPQL() {
		return productService.fetchAllProductsUsingJPQL();
	}

	@GetMapping("/fetchProductbyNameUsingJPQL/{pname}")
	public Product fetchProductbyNameUsingJPQL(@PathVariable("pname") String pname) {

		return productService.fetchProductbyNameUsingJPQL(pname);
	}

	@GetMapping("/fetchProductbyNameAndPriceUsingJPQL/{pprice}/{pname}")
	public Product fetchProductbyNameAndPriceUsingJPQL(String productName, double productPrice) {
		return productService.fetchProductbyNameAndPriceUsingJPQL(productName, productPrice);
	}

	@GetMapping("/fetchProductsUsingInnerJoinUsingJPQL")
	public List<Product> fetchProductsUsingInnerJoinUsingJPQL() {
		return productService.fetchProductsUsingInnerJoinUsingJPQL();
	}

	@GetMapping("/fetchProductDetailsUsingMultipleColumnsUsingJPQL/{id}")
	public List<Object[]> fetchProductDetailsUsingMultipleColumnsUsingJPQL(@PathVariable("id") Integer id) {
		return  productService.fetchProductDetailsUsingMultipleColumnsUsingJPQL(id);

	}

	@GetMapping("/fetchAllProductsUsingNativeQueryUsingJPQL/{id}")
	public List<Product> fetchAllProductsUsingNativeQueryUsingJPQL() {
		return productService.fetchAllProductsUsingNativeQueryUsingJPQL();
	}

	@GetMapping("/getAllProductsUsingJPQL/{pname}")
	public List<Product> getAllProductsUsingJPQL(@PathVariable("pname") String pname) {
		return productService.getAllProductsUsingJPQL(pname);
	}

}
