package com.javaweb.service;

import com.javaweb.domain.User;

public interface UserService {

	User findByNameAndPsw(String username, String password);

	void save(User user);

}
