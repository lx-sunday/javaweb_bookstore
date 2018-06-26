package com.javaweb.service;

import com.javaweb.domain.Book;
import com.javaweb.domain.Page;

public interface BookService {

	void save(Book book);

	Page getPage(String pagenum);

}
