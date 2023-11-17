package com.javaexpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javaexpress.models.Category;
import com.javaexpress.models.Product;
import com.javaexpress.models.Status;
import com.javaexpress.repository.ProductRepository;
import com.javaexpress.service.CategoryService;
import com.javaexpress.service.ProductService;
import com.javaexpress.service.responses.ProductBoResponse;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		Category dbCategory = categoryService.fetchCategory(product.getCategory().getId());
		product.setCategory(dbCategory);
		product.setStatus(Status.NEW);
		return productRepository.save(product);
	}

	public ProductBoResponse fetchProductsUsingPagination(PageRequest pageRequest) {
		Page<Product> page = productRepository.findAll(pageRequest);

		ProductBoResponse response = new ProductBoResponse(page.getTotalPages(), page.getTotalElements(),
				page.getContent());

		return response;
	}

	@Override
	public Product fetchProduct(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public Product fetchProductUsingPrice(double price) {
		return productRepository.findByPrice(price);
	}

	@Override
	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Integer productId, Product product) {

		return productRepository.save(product);
	}

	@Override
	public Optional<Product> fetchProduct(Integer productId) {

		return productRepository.findById(productId);
	}

	@Override
	public void deleteProductById(Integer productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public void deleteAllProducts() {
		productRepository.deleteAll();

	}

	@Override
	public Product fetchProductUsingNameAndPrice(String pname, double price) {
 		return productRepository.fetchProductbyNameAndPrice(pname, price);
	}

	@Override
	public Product fetchProductByNameOrPrice(String pname, double price) {
		return productRepository.findByNameOrPrice(pname, price);
	}

	@Override
	public List<Product> fetchProductByPriceLessThan(double price) {
		return productRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Product> fetchProductByPriceGreaterThan(double price) {
		return productRepository.findByPriceGreaterThan(price);
	}

	@Override
	public List<Product> fetchProductByPriceOrderByNameAsc(double price) {
		return productRepository.findByPriceOrderByNameAsc(price);
	}

	@Override
	public List<Product> fetchProductByPriceOrderByNameDesc(double price) {
		return productRepository.findByPriceOrderByNameDesc(price);
	}

	@Override
	public List<Product> fetchProductByActiveTrue() {
		return productRepository.findByActiveTrue();
	}

	@Override
	public List<Product> fetchProductByActiveFalse() {
		return productRepository.findByActiveFalse();
	}

	@Override
	public List<Product> fetchProductByActive(boolean status) {
		return productRepository.findByActive(status);
	}

	@Override
	public List<Product> fetchProductByCategoryName(String name) {
		return productRepository.findByCategoryName(name);
	}

	@Override
	public List<Product> fetchProductByNameContaining(String name) {
		return productRepository.findByNameContaining(name);
	}

}
