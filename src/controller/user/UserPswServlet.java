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
		//����ҳ������
		String id=req.getParameter("userid");
		//����һ��userservice����
		UserServiceImpl us=new UserServiceImpl();
		//����ͨ��id�޸�����ķ���
		User user=us.getById(id);
		String rpsw=user.getUserpsw();
		String psw=req.getParameter("oldpass");
		String npsw=req.getParameter("newpass");
		PrintWriter out = resp.getWriter();
		if(rpsw.equals(psw)) {
			//������ȷ�����޸�
			//�����޸ĵķ���
			boolean isOK=us.updatePsw(npsw, id);
			if(isOK) {
				//�޸�����ɹ�
				out.write("true");
			}else {
				//�޸�����ʧ��
				out.write("false");
			}
		}else {
				//�޸�����ʧ��
				out.write("false");
		}
		out.flush();
		out.close();
	}

}
