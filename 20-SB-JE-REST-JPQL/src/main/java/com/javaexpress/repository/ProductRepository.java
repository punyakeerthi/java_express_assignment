package com.javaexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaexpress.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	// findById
	//DSL
	
	// select * from product where name='iphone11'
	Product findByName(String pname);
	
	Product findByPrice(double price);
	
	// select * from product where name='iphone11' & price=950
	Product findByNameAndPrice(String pname,double price);
	
	Product findByNameOrPrice(String pname,double price);
	
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByPriceOrderByNameAsc(double price);
	
	List<Product> findByPriceOrderByNameDesc(double price);
	
	List<Product> findByActiveTrue();
	
	List<Product> findByActiveFalse();
	
	List<Product> findByActive(boolean status);
	
	List<Product> findByCategoryName(String name);	
	
	List<Product> findByNameContaining(String name);
	
	
	// JPQL - method syntax not required becuse we are using @Query annotation 
	
	@Query("select p from Product p")
	List<Product> fetchAllProducts();
	
	@Query("select p from Product p where p.name=:productName")
	Product fetchProductbyName(String productName);
	
	@Query("select p from Product p where p.name=:productName and p.price=:productPrice")
	Product fetchProductbyNameAndPrice(String productName,double productPrice);
	
	@Query("select p from Product p INNER JOIN Category c on p.id=c.id")
	List<Product> fetchProductsUsingInnerJoin();
	
	@Query("select id,name,price from Product p where p.id=:id")
	List<Object[]> fetchProductDetailsUsingMultipleColumns(Integer id);
	
	@Query(value="select * from product",nativeQuery = true)
	List<Product> fetchAllProductsUsingNativeQuery();
	
	// calling stored procedures
	@Query(nativeQuery = true,value="call getAllProducsByName(:name)")
	List<Product> getAllProducts(String name);
	
	
	
	
	
	
	
	
}
