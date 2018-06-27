package com.javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.domain.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {



	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request=(HttpServletRequest)srequest;
		HttpServletResponse response=(HttpServletResponse)sresponse;
		String path = request.getServletPath();
		if(path.equals("/LoginServlet") || path.equals("/RegisterServlet") || path.equals("/register.jsp")){ //排除登录与注册
			chain.doFilter(request, response);
		}else{
			User user=(User)request.getSession().getAttribute("user");
			if(user==null){
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
