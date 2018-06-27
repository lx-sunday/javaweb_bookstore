package com.javaweb.service.impl;

import com.javaweb.dao.UserDao;
import com.javaweb.domain.User;
import com.javaweb.service.UserService;
import com.javaweb.utils.BeanFactory;

public class UserServiceImpl implements UserService {
	
	UserDao dao=BeanFactory.getInstance().createBean("com.javaweb.dao.impl.UserDaoImpl",UserDao.class);

	@Override
	public User findByNameAndPsw(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByNameAndPsw(username,password);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		dao.save(user);
	}

}
