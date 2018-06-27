package com.javaweb.dao;

import com.javaweb.domain.User;

public interface UserDao {

	User findByNameAndPsw(String username, String password);

	void save(User user);

}
