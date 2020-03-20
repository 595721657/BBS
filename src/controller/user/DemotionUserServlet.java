package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.user.impl.UserServiceImpl;
import utils.DButils;
@WebServlet("/DemotionUser")
public class DemotionUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5092376728269210828L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收页面数据
		String userid=req.getParameter("id");
		//创建一个service对象
		UserServiceImpl us=new UserServiceImpl();
		//调用降级的方法
		boolean isOK=us.DemotionUser(userid ,DButils.getDate());
		PrintWriter out = resp.getWriter();
		if(isOK) {
			//降级成功
			out.write("true");
		}else {
			//降级失败
			out.write("false");
		}
		out.flush();
		out.close();
	}

}
