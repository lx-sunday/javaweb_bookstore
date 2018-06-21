package com.javaweb.service.impl;

import java.util.List;

import com.javaweb.dao.CategoryDao;
import com.javaweb.domain.Category;
import com.javaweb.service.CategoryService;
import com.javaweb.utils.BeanFactory;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao dao=BeanFactory.getInstance().createBean("com.javaweb.dao.impl.CategoryDaoImpl",CategoryDao.class);

	@Override
	public void add(Category bean) {
		// TODO Auto-generated method stub
		dao.add(bean);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
