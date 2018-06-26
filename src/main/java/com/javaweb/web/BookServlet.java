package com.javaweb.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.javaweb.domain.Book;
import com.javaweb.domain.Category;
import com.javaweb.domain.Page;
import com.javaweb.service.BookService;
import com.javaweb.service.CategoryService;
import com.javaweb.utils.BeanFactory;
import com.javaweb.utils.WebUtils;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookService service=BeanFactory.getInstance().createBean("com.javaweb.service.impl.BookServiceImpl",BookService.class);
	CategoryService cService=BeanFactory.getInstance().createBean("com.javaweb.service.impl.CategoryServiceImpl",CategoryService.class);
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		String method= request.getParameter("method");
		if("add".equals(method)){ //跳转到添加页面
			add(request,response);
			
		}else if("save".equals(method)){ //执行保存功能
			save(request,response);
			
		}else if("list".equals(method)){ //查询列表
			list(request,response);
			
		}else{
			
		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			 String pagenum=request.getParameter("pagenum");
			 Page page=service.getPage(pagenum);
			 request.setAttribute("page", page);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.getRequestDispatcher("/manager/list_book.jsp").forward(request, response);
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Book book=parseRequest(request);
			book.setId(WebUtils.makeId());
			service.save(book);
			request.setAttribute("massage", "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("massage", "添加失败");
		}
		request.getRequestDispatcher("/manager/result.jsp").forward(request, response);	
	}
    /**
     * 解析form表单传递参数（包含上传文件）
     * @param request
     * @return
     * @throws FileUploadException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws IOException 
     */
	private Book parseRequest(HttpServletRequest request) throws FileUploadException, IllegalAccessException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
		Book book=new Book();
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()){
			FileItem item = iter.next();
			if(item.isFormField()){  //processFormField
				String name = item.getFieldName();
				String value = item.getString("utf-8");
				BeanUtils.setProperty(book,name,value);
			}else{  //processUploadedFile
				String imageName=processUploadedFile(item);
				book.setImage(imageName);
			}
		}
		return book;
	}


    /**
     * 处理上传文件
     * @param item
     * @return 返回web容器的图片路径
     * @throws IOException 
     */
	private String processUploadedFile(FileItem item) throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = item.getInputStream();
		//得到图片文件名
		String uploadFileName =item.getName();
		String ext = uploadFileName.substring(uploadFileName.indexOf(".")+1);
		String fileName=WebUtils.makeId()+"."+ext;
		//把上传图片文件流写入到web容器中
		String realPath = this.getServletContext().getRealPath("/images");
		String filePath=realPath+"/"+fileName;
		OutputStream os=new FileOutputStream(filePath);
		byte[] bytes=new byte[1024];
		int len=0;
		while((len=inputStream.read(bytes))>0){
			os.write(bytes, 0, len);
		}
		inputStream.close();
		os.close();
		
		return "/images/"+fileName;
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> cateList = cService.findAll();
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher("/manager/add_book.jsp").forward(request, response);
	}

}
