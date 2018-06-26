package com.javaweb.service.impl;

import com.javaweb.dao.BookDao;
import com.javaweb.dao.CategoryDao;
import com.javaweb.domain.Book;
import com.javaweb.domain.Page;
import com.javaweb.service.BookService;
import com.javaweb.utils.BeanFactory;

public class BookServiceImpl implements BookService {
	
	BookDao dao=BeanFactory.getInstance().createBean("com.javaweb.dao.impl.BookDaoImpl",BookDao.class);
	
	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		this.dao.save(book);
	}

	@Override
	public Page getPage(String pagenum) {
		// TODO Auto-generated method stub
		int totalSize=this.dao.getTotalSize();
		Integer pageNo=pagenum==null?1:Integer.valueOf(pagenum);
		Page page=this.dao.getPage(new Page(pageNo,totalSize));
		return page;
	}

}
