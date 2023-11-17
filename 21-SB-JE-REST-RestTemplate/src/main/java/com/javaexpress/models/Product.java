package com.javaexpress.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Setter
@Getter
@NoArgsConstructor
public class Product {

 	private Integer id;
	
	
	private String name;
	
	private Double price;
	
	private boolean active;
	
	private String description;
	
 	private String barCode;
	
 	private Status status;
	
  
 	private Category category;
	
}
