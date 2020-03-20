package controller.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import entity.Category;
import entity.Invitation;
import entity.InvitationAns;
import entity.Level;
import entity.Plate;
import entity.User;
import service.category.impl.CategoryServiceImpl;
import service.invitation.impl.InvitationServiceImpl;
import service.invitation_ans.impl.Invitation_ansServiceImpl;
import service.level.impl.LevelServiceImpl;
import service.plant.impl.PlantServiceImpl;
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
		//���ñ����ʽ8
		req.setCharacterEncoding("UTF-8");
	    //����һ�������û���ҳ�������
		UserServiceImpl us=new UserServiceImpl();
		List<User> user=us.getUserAll();
		//Ϊ�������
		String psw=null;
		for (int i = 0; i < user.size(); i++) {
			psw=DigestUtils.md5Hex(user.get(i).getUserpsw());
			user.get(i).setUserpsw(psw);
		}
		//����һ�����������sevice
		PlantServiceImpl ps=new PlantServiceImpl();
		List<Plate> plate=ps.getAllPlate();
		//����һ����������service
		CategoryServiceImpl cs=new CategoryServiceImpl();
		List<Category> category=cs.getall();
		//����һ�������ȼ���service
		LevelServiceImpl ls=new LevelServiceImpl();
		List<Level> level=ls.getall();
		//����һ������������service
		InvitationServiceImpl is=new InvitationServiceImpl();
		List<Invitation>  invitation=is.getall();
		//����һ����������������
		Invitation_ansServiceImpl iss=new Invitation_ansServiceImpl();
		List<InvitationAns> invitation_ans=iss.getInvitation_ans();
	    //��ȡҳ������
		String userid=req.getParameter("username");
		String userpsw=req.getParameter("password");
	    boolean isOk=us.validation(userid, userpsw);
	    if(isOk) {
	    	//��¼�ɹ�
	    	//���û����洢��������
	    	req.getSession().setAttribute("name", userid);
	    	req.getSession().setAttribute("user", user);
	    	req.getSession().setAttribute("plate", plate);
	    	req.getSession().setAttribute("category", category);
	    	req.getSession().setAttribute("invitation", invitation);
	    	req.getSession().setAttribute("level", level);
	    	req.getSession().setAttribute("invitation_ans", invitation_ans);
	    	//req.getSession().setAttribute("name", userid);
	    	//req.getSession().setAttribute("name", userid);
	    	//req.getSession().setAttribute("name", userid);
	    	//req.getSession().setAttribute("name", userid);
	    	req.getRequestDispatcher("server/index.jsp").forward(req, resp);
	    }else {
	    	//��¼ʧ��
	    	resp.sendRedirect("static/login.jsp");
	    }		
	}

}
