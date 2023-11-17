package com.javaexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.models.Category;
import com.javaexpress.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
		
		// assingment
		//categoryRepository.saveAll(null);
		//categoryRepository.count();
		//categoryRepository.findAllById();
		//categoryRepository.deleteById(null);
	}
	
	public Category updateCategory(Integer id,Category inputCategory) {
		Category dbCategory = fetchCategory(id);
		dbCategory.setName(inputCategory.getName());
		return categoryRepository.save(dbCategory);
	}
	
	public Category fetchCategory(Integer id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Category Id Not exits in DB");
		}
	}
	
	public void deleteCategory(Integer id) {
		Category dbCategory = fetchCategory(id);
		categoryRepository.delete(dbCategory);
	}

	public List<Category> fetchAllCategories() {
		return categoryRepository.findAll();
	}
	
}
