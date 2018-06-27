package com.javaweb.dao.impl;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.javaweb.dao.UserDao;
import com.javaweb.domain.User;
import com.javaweb.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findByNameAndPsw(String username, String password) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="SELECT * from `user` where username=? and `password`=?";
			Object[] params={username,password};
			user=(User)qr.query(sql, params, new BeanHandler<User>(User.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="INSERT into `user` (id,username,password,phone,cellphone,email,address) VALUES(?,?,?,?,?,?,?)";
			Object[] params={user.getId(),user.getUsername(),user.getPassword(),user.getPhone(),user.getCellphone(),user.getEmail(),user.getAddress()};
			qr.update(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
