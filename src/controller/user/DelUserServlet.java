package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.user.impl.UserServiceImpl;
@WebServlet("/DelUser")
public class DelUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7733425331052028189L;

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
		//����һ��service����
		UserServiceImpl us=new UserServiceImpl();
		//����ɾ���ķ���
		boolean isOK=us.deleteUser(userid);
		PrintWriter out = resp.getWriter();
		if(isOK) {
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
