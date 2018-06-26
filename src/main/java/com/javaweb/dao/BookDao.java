package com.javaweb.dao;

import com.javaweb.domain.Book;
import com.javaweb.domain.Page;

public interface BookDao {

	void save(Book book);

	int getTotalSize();

	Page getPage(Page page);

}
