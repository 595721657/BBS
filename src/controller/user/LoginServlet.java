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
		//设置编码格式8
		req.setCharacterEncoding("UTF-8");
	    //创建一个操作用户的页面类对象
		UserServiceImpl us=new UserServiceImpl();
	   //获取页面数据
		String userid=req.getParameter("username");
		String userpsw=req.getParameter("password");
	    boolean isOk=us.validation(userid, userpsw);
	    if(isOk) {
	    	//登录成功
	    	//将用户名存储在作用域
	    	req.setAttribute("name", userid);
	    	req.getRequestDispatcher("server/index.jsp").forward(req, resp);
	    }else {
	    	//登录失败
	    	resp.sendRedirect("static/login.jsp");
	    }		
	}

}
