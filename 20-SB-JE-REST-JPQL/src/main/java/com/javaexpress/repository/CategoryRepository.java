package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
