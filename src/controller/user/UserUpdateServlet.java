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
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		//������Ҫ���յı���
		String usermail=null;
		String userphoto=null;
		String usersex=null;
		String userid=null;
		// ����ļ��ϴ���·��
		String filePath = this.getServletContext().getRealPath("/static/file");
		// �鿴�Ƿ���
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(isMultipart) {
			// ����һ����������
			FileItemFactory fac = new DiskFileItemFactory();
			// ����һ���ļ��ϴ��Ķ���
			ServletFileUpload upload = new ServletFileUpload(fac);
			// ��ñ��е��������� ����10M
			upload.setFileSizeMax(10*1024*1024);
			try {
				List<FileItem> items = upload.parseRequest(req);
				// �������е���������
				Iterator<FileItem> it = items.iterator();
				while (it.hasNext()) {
					// ȡ��Ԫ�ض���
					FileItem item = it.next();
					// �ж��Ƿ�����ͨ�ı�Ԫ��
					if(item.isFormField()) {
						String name = item.getFieldName();// �õ�����nameֵ
						// ����nameֵ��Ϊ����ı�����ֵ
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
		// ����һ��Ҫ���浽���ݿ����û��Ķ���
		User user=new User(userid, usermail, usersex, userphoto);
		//����һ��service����
		UserServiceImpl ad = new UserServiceImpl();	
		boolean result=ad.updateUser(user);
		PrintWriter out = resp.getWriter();
		if(result) {
			//ɾ���ɹ�
			out.write("true");
		}else {
			//ɾ��ʧ��
			out.write("false");
		}
		out.flush();
		out.close();
	}
}
