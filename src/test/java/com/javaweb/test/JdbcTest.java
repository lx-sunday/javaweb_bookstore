package com.javaweb.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.javaweb.domain.User;
import com.javaweb.utils.JdbcUtils;

public class JdbcTest {
	
	@Test
	public void findUser(){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="SELECT * from user";
			List<User> list= qr.query(sql, null,  new BeanListHandler(User.class));
			if(list!=null){
				for(User user :list){
					System.out.println(user.getUsername()+" : "+user.getPassword());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
