package com.javaweb.web;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.domain.Category;
import com.javaweb.service.CategoryService;
import com.javaweb.utils.BeanFactory;
import com.javaweb.utils.WebUtils;

/**
 * 分类管理servlet
 * @author lx
 *
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CategoryService service=BeanFactory.getInstance().createBean("com.javaweb.service.impl.CategoryServiceImpl",CategoryService.class);
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}
		if("list".equals(method)){
			list(request,response);
		}
		if("del".equals(method)){
			del(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Category bean=new Category();
			bean.setId(WebUtils.makeId());
			bean.setName(request.getParameter("name"));
			bean.setDescription(request.getParameter("description"));
			service.add(bean);
			request.setAttribute("massage", "添加成功");
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("massage", "添加失败");
		}
		request.getRequestDispatcher("/manager/result.jsp").forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    try {
			List<Category> list = service.findAll();
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    request.getRequestDispatcher("manager/list_cate.jsp").forward(request, response);
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("manager/list_cate.jsp").forward(request, response);
	}
}
