package com.javaweb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.domain.User;
import com.javaweb.service.UserService;
import com.javaweb.utils.BeanFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService service=BeanFactory.getInstance().createBean("com.javaweb.service.impl.UserServiceImpl",UserService.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username==null || password==null){
			request.setAttribute("message", "用户名或密码不能为空");
		}else{
			User user=service.findByNameAndPsw(username,password);
			if(user==null){
				request.setAttribute("message", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/client/index.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
