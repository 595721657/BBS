package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.user.impl.UserServiceImpl;
import utils.DButils;
@WebServlet("/DisableUser")
public class DisableUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6507179827627187285L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		//����ҳ������
		String userid=req.getParameter("id");
		String date=req.getParameter("person");
		//����һ��service����
		UserServiceImpl us=new UserServiceImpl();
		//���ý��õķ���
		Date new_date=null;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			new_date=format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean isOK=us.DisableUser(userid,new_date);
		 PrintWriter out = resp.getWriter();
		 if(isOK) { 
			 //�����ɹ�
			 out.write("true");
		 }else { 
			 //����ʧ�� 
			 out.write("false"); 
			 } 
		 out.flush(); 
		 out.close();
		 }
	}
