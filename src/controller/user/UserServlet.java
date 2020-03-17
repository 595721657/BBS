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
		//创建一个用户service对象
		UserServiceImpl us=new UserServiceImpl();
		//调用查询所有所有数据的方法
		int counts=us.getAll();
		List<User> user=us.getUserAll();
		String psw=null;
		for (int i = 0; i < user.size(); i++) {
			psw=DigestUtils.md5Hex(user.get(i).getUserpsw());
			user.get(i).setUserpsw(psw);
		}
		//将数据存在session中
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("counts", counts);
		//实现页面跳转
		req.getRequestDispatcher("/server/member-list.jsp").forward(req, resp);
	}

}
