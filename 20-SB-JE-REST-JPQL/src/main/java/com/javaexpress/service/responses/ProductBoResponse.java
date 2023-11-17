package com.javaexpress.service.responses;

import java.util.List;

import com.javaexpress.models.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductBoResponse {

	int totalPageNumbers;
	long totalNoOfElements;
	List<Product> products;
}
