package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.user.impl.UserServiceImpl;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ8
		req.setCharacterEncoding("UTF-8");
	    //����һ�������û���ҳ�������
		UserServiceImpl us=new UserServiceImpl();
	   //��ȡҳ������
		String userid=req.getParameter("username");
		String userpsw=req.getParameter("password");
	    boolean isOk=us.validation(userid, userpsw);
	    if(isOk) {
	    	//��¼�ɹ�
	    	//���û����洢��������
	    	req.setAttribute("name", userid);
	    	req.getRequestDispatcher("server/index.jsp").forward(req, resp);
	    }else {
	    	//��¼ʧ��
	    	resp.sendRedirect("static/login.jsp");
	    }		
	}

}
