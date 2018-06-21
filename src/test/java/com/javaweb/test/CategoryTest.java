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
			bean.setName("Ӣ���鼮");
			bean.setDescription("Ӣ��������鼮");
			service.add(bean);
			System.out.println("��ӳɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���ʧ��");
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
