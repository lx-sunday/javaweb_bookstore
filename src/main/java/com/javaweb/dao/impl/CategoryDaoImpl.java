package com.javaweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.javaweb.dao.CategoryDao;
import com.javaweb.domain.Category;
import com.javaweb.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void add(Category bean) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="INSERT INTO category (id,name,description) VALUES(?,?,?)";
			Object[] params={bean.getId(),bean.getName(),bean.getDescription()};
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="SELECT * from category";
			List<Category> list = qr.query(sql, new BeanListHandler<>(Category.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
