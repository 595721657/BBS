package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import entity.User;
import service.user.impl.UserServiceImpl;
@WebServlet("/User")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4038621191666909604L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����һ���û�service����
		UserServiceImpl us=new UserServiceImpl();
		//���ò�ѯ�����������ݵķ���
		int counts=us.getAll();
		List<User> user=us.getUserAll();
		String psw=null;
		for (int i = 0; i < user.size(); i++) {
			psw=DigestUtils.md5Hex(user.get(i).getUserpsw());
			user.get(i).setUserpsw(psw);
		}
		//�����ݴ���session��
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("counts", counts);
		//ʵ��ҳ����ת
		req.getRequestDispatcher("/server/member-list.jsp").forward(req, resp);
	}

}
