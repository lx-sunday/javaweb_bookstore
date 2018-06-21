package com.javaweb.utils;

public class BeanFactory {

	private static final BeanFactory bf=new BeanFactory();
	
	private BeanFactory(){};
	
	public static BeanFactory getInstance(){
		
		return bf;
	}
	
	public <T> T  createBean(String className, Class<T> clazz){
		
		try {
			T t= (T)Class.forName(className).newInstance();
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
