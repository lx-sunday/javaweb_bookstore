package com.javaweb.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.javaweb.domain.User;
import com.javaweb.service.UserService;
import com.javaweb.utils.BeanFactory;
import com.javaweb.utils.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	UserService service=BeanFactory.getInstance().createBean("com.javaweb.service.impl.UserServiceImpl",UserService.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			User user=new User();
			user.setId(WebUtils.makeId());
			Enumeration<String> em = request.getParameterNames();
			while(em.hasMoreElements()){
				String name = em.nextElement();
				String value = request.getParameter(name);
				BeanUtils.copyProperty(user, name, value);
			}
			service.save(user);
			request.setAttribute("message", "注册成功，请登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "注册失败，请重新注册");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
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
