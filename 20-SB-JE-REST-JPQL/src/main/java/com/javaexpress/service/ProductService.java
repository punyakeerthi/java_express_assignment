package com.javaexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import com.javaexpress.models.Product;
import com.javaexpress.service.responses.ProductBoResponse;

public interface ProductService {

	public Product createProduct(Product product);
	
	public List<Product> fetchAllProducts();

	public Product updateProduct(Integer productId, Product product);

	public Optional<Product> fetchProduct(Integer productId);

	public void deleteProductById(Integer productId);

	public void deleteAllProducts();
	
	
	public ProductBoResponse fetchProductsUsingPagination(PageRequest pageRequest);

	public Product fetchProduct(String name);

	public Product fetchProductUsingPrice(double price);

	Product fetchProductUsingNameAndPrice(String pname,double price);
	
	
	
     Product fetchProductByNameOrPrice(String pname,double price);
	
	List<Product> fetchProductByPriceLessThan(double price);
	
	List<Product> fetchProductByPriceGreaterThan(double price);
	
	List<Product> fetchProductByPriceOrderByNameAsc(double price);
	
	List<Product> fetchProductByPriceOrderByNameDesc(double price);
	
	List<Product> fetchProductByActiveTrue();
	
	List<Product> fetchProductByActiveFalse();
	
	List<Product> fetchProductByActive(boolean status);
	
	List<Product> fetchProductByCategoryName(String name);	
	
	List<Product> fetchProductByNameContaining(String name);
	 
	List<Product> fetchAllProductsUsingJPQL();
	 
	Product fetchProductbyNameUsingJPQL(String productName);
	
 	Product fetchProductbyNameAndPriceUsingJPQL(String productName,double productPrice);
	
 	List<Product> fetchProductsUsingInnerJoinUsingJPQL();
	
 	List<Object[]> fetchProductDetailsUsingMultipleColumnsUsingJPQL(Integer id);
	
 	List<Product> fetchAllProductsUsingNativeQueryUsingJPQL();
	
	List<Product> getAllProductsUsingJPQL(String name);
}
