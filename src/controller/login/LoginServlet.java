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
import utils.DButils;
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
		List<User> user=us.getUserAll();
		//为密码加密
		String psw=null;
		for (int i = 0; i < user.size(); i++) {
			psw=DigestUtils.md5Hex(user.get(i).getUserpsw());
			user.get(i).setUserpsw(psw);
		}
		//创建一个操作主题的sevice
		PlantServiceImpl ps=new PlantServiceImpl();
		List<Plate> plate=ps.getAllPlate();
		//创建一个操作板块的service
		CategoryServiceImpl cs=new CategoryServiceImpl();
		List<Category> category=cs.getall();
		//创建一个操作等级的service
		LevelServiceImpl ls=new LevelServiceImpl();
		List<Level> level=ls.getall();
		//创建一个操作主贴的service
		InvitationServiceImpl is=new InvitationServiceImpl();
		List<Invitation>  invitation=is.getall();
		//创建一个操作回帖的数据
		Invitation_ansServiceImpl iss=new Invitation_ansServiceImpl();
		List<InvitationAns> invitation_ans=iss.getInvitation_ans();
	    //获取页面数据
		String userid=req.getParameter("username");
		String userpsw=req.getParameter("password");
		//提供userid查询数据
		User new_user=us.getById(userid);
		//判断是否禁用
		
	    boolean isOk=false;
        if(new_user.getUserlock()==null) {
          isOk=us.validation(userid, userpsw);
        	 if(isOk) {
        	    	//登录成功
        	    	//将用户名存储在作用域
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
        	    	//登录失败
        	    	resp.sendRedirect("static/login.jsp");
        	    }	
        }else {
        	boolean isPass=us.disableUser(DButils.getDate(),new_user.getUserlock());
        	if(isPass) {
        		isOk=us.validation(userid, userpsw);
           	 if(isOk) {
           	    	//登录成功
           	    	//将用户名存储在作用域
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
           	         //登录失败
           	    	resp.sendRedirect("static/login.jsp");
           	    }	
        	}else {
        		//登录失败
       	    	resp.sendRedirect("static/login.jsp");
            }
        }
	}

}
