package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Category;

public interface CategoryDao {

	void add(Category bean);

	List<Category> findAll();

}
