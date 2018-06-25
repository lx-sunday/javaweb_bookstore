package com.javaweb.test;

import java.util.List;

import org.junit.Test;

import com.javaweb.dao.CategoryDao;
import com.javaweb.domain.Category;
import com.javaweb.service.CategoryService;
import com.javaweb.service.impl.CategoryServiceImpl;
import com.javaweb.utils.BeanFactory;
import com.javaweb.utils.WebUtils;

public class CategoryTest {
	
	CategoryService service=BeanFactory.getInstance().createBean("com.javaweb.service.impl.CategoryServiceImpl",CategoryService.class);
	
	@Test
	public void add(){
		try {
			Category bean=new Category();
			bean.setId(WebUtils.makeId());
			bean.setName("英语书籍");
			bean.setDescription("英语类相关书籍");
			service.add(bean);
			System.out.println("添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void findList(){
		
		try {
			List<Category> list = service.findAll();
			if(list!=null){
				for(Category bean : list){
					System.out.println(bean.getName()+":"+bean.getDescription());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
