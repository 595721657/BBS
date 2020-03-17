package controller.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.User;
import service.user.impl.UserServiceImpl;
@WebServlet("/UserUpdate")
public class UserUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1766261148369408693L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//声明需要接收的变量
		String usermail=null;
		String userphoto=null;
		String usersex=null;
		String userid=null;
		// 获得文件上传的路径
		String filePath = this.getServletContext().getRealPath("/static/file");
		// 查看是否是
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(isMultipart) {
			// 创建一个工厂对象
			FileItemFactory fac = new DiskFileItemFactory();
			// 创建一个文件上传的对象
			ServletFileUpload upload = new ServletFileUpload(fac);
			// 获得表单中的所有请求 限制10M
			upload.setFileSizeMax(10*1024*1024);
			try {
				List<FileItem> items = upload.parseRequest(req);
				// 遍历所有的请求内容
				Iterator<FileItem> it = items.iterator();
				while (it.hasNext()) {
					// 取出元素对象
					FileItem item = it.next();
					// 判断是否是普通的表单元素
					if(item.isFormField()) {
						String name = item.getFieldName();// 得到表单的name值
						// 根据name值，为上面的变量赋值
						switch (name) {
						case "userid":
							userid = item.getString("UTF-8");
							break;
						case "usersex":
							usersex = item.getString("UTF-8");
							break;
						case "email":
							usermail = item.getString("UTF-8");
							break;
	                    }
					}else {
						userphoto = item.getName();
						File saveFile1 = new File(filePath, userphoto);
						item.write(saveFile1);
					}
				}
				}catch(FileUploadException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		  }
		// 创建一个要保存到数据库中用户的对象
		User user=new User(userid, usermail, usersex, userphoto);
		//创建一个service对象
		UserServiceImpl ad = new UserServiceImpl();	
		boolean result=ad.updateUser(user);
		PrintWriter out = resp.getWriter();
		if(result) {
			//删除成功
			out.write("true");
		}else {
			//删除失败
			out.write("false");
		}
		out.flush();
		out.close();
	}
}
