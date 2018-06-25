package com.javaweb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.domain.Category;
import com.javaweb.service.BookService;
import com.javaweb.service.CategoryService;
import com.javaweb.utils.BeanFactory;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookService service=BeanFactory.getInstance().createBean("com.javaweb.service.impl.BookServiceImpl",BookService.class);
	CategoryService cService=BeanFactory.getInstance().createBean("com.javaweb.service.impl.CategoryServiceImpl",CategoryService.class);
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		if("add".equals(request.getAttribute("method"))){ //跳转到添加页面
			add(request,response);
			
		}else if("save".equals(request.getAttribute("method"))){ //执行保存功能
			save(request,response);
			
		}else if("list".equals(request.getAttribute("method"))){ //查询列表
			list(request,response);
			
		}else{
			
		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//http://commons.apache.org/proper/commons-fileupload/using.html
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> cateList = cService.findAll();
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher("/manager/add_book.jsp").forward(request, response);
	}

}
