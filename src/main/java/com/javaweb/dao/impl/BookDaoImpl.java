package com.javaweb.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.javaweb.dao.BookDao;
import com.javaweb.domain.Book;
import com.javaweb.domain.Page;
import com.javaweb.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="INSERT INTO book (id,name,author,price,image,description,category_id) VALUES(?,?,?,?,?,?,?)";
			Object[] params={book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getImage(),book.getDescription(),book.getCategory_id()};
			qr.update(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalSize() {
		// TODO Auto-generated method stub
		int total=0;
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="SELECT COUNT(*) from book";
			Object object = qr.query(sql, new ScalarHandler());
			if(object!=null){
				total=Integer.parseInt(object.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
		return total;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page getPage(Page page) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="SELECT * from book LIMIT ?,?";
			Object[] params={page.getStartindex(),page.getPagesize()};
			List<Book> list = qr.query(sql, params, new BeanListHandler<>(Book.class));
			page.setList(list);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return page;
	}

}
