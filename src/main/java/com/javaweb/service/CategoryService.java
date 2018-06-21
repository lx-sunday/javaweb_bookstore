package com.javaweb.service;

import java.util.List;

import com.javaweb.domain.Category;

public interface CategoryService {
	
	public void add(Category bean);
	
	public List<Category> findAll();

}
