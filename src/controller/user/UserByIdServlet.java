package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.user.impl.UserServiceImpl;
@WebServlet("/UserById")
public class UserByIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 111999992405138992L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		//����ҳ������
		String id=req.getParameter("id");
		String op=req.getParameter("op");
		//����һ��userservice����
		UserServiceImpl us=new UserServiceImpl();
		//����ͨ��id��ѯ���ݵķ���
		User user=us.getById(id);
		req.setAttribute("users", user);
		if(op.equals("bj")) {
			//ҳ����ת
			req.getRequestDispatcher("server/member-edit.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("server/member-password.jsp").forward(req, resp);
		}
	}

}
