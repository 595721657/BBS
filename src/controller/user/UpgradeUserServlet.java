package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.user.impl.UserServiceImpl;
@WebServlet("/UpgradeUser")
public class UpgradeUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8409113488006776182L;

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
		//调用升级的方法
		boolean isOK=us.UpgradeUser(userid);
		PrintWriter out = resp.getWriter();
		if(isOK) {
			//升级成功
			out.write("true");
		}else {
			//升级失败
			out.write("false");
		}
		out.flush();
		out.close();
	}

}
