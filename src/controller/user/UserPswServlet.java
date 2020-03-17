package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.user.impl.UserServiceImpl;
@WebServlet("/UserPsw")
public class UserPswServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594173526506678116L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收页面数据
		String id=req.getParameter("userid");
		//创建一个userservice对象
		UserServiceImpl us=new UserServiceImpl();
		//调用通过id修改密码的方法
		User user=us.getById(id);
		String rpsw=user.getUserpsw();
		String psw=req.getParameter("oldpass");
		String npsw=req.getParameter("newpass");
		PrintWriter out = resp.getWriter();
		if(rpsw.equals(psw)) {
			//密码正确可以修改
			//调用修改的方法
			boolean isOK=us.updatePsw(npsw, id);
			if(isOK) {
				//修改密码成功
				out.write("true");
			}else {
				//修改密码失败
				out.write("false");
			}
		}else {
				//修改密码失败
				out.write("false");
		}
		out.flush();
		out.close();
	}

}
