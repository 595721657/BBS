package controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import entity.User;
import service.user.impl.UserServiceImpl;
@WebServlet("/UserByUserid")
public class UserByUseridServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8759830204483437686L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收页面数据
		String userid=req.getParameter("user");
		//创建一个service对象
		UserServiceImpl us=new UserServiceImpl();
		//创建一个集合
		List<User> user=new ArrayList<User>();
		if(userid.equals("") || userid=="") {
			user=us.getUserAll();
		}else {
			user=us.getUserByUserid(userid);
		}
		String ss=null;
		for (int i = 0; i < user.size(); i++) {
			ss=DigestUtils.md5Hex(user.get(i).getUserpsw());
			user.get(i).setUserpsw(ss);
		}
		req.getSession().setAttribute("user", user);
		//实现页面跳转
		req.getRequestDispatcher("/server/member-list.jsp").forward(req, resp);
	}

}
