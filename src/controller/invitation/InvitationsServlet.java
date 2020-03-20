package controller.invitation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Invitation;
import entity.InvitationAns;
import service.invitation.impl.InvitationServiceImpl;
import service.invitation_ans.impl.Invitation_ansServiceImpl;
import utils.DButils;
@WebServlet("/InvitationServlet")
public class InvitationsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3268682270687173053L;
    //创建一个service层对象
	InvitationServiceImpl is=new InvitationServiceImpl();
	Invitation_ansServiceImpl iss=new Invitation_ansServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    //设置编码格式
		req.setCharacterEncoding("UTF-8");
		List<Invitation> list=null;
		//接收页面传递过来的参数
		String op=req.getParameter("op");
		if("add".equals(op)) {
			//调用增加的方法
			addInvitation(req,resp);
			list=is.getall();
			req.getSession().setAttribute("invitation", list);
		}else if("findid".equals(op)) {
			//调用查询的方法
			getByIdInvitation(req,resp);
		}else if("del".equals(op)) {
			//调用删除单个的方法
			delInvitation(req,resp);
		}else if("delall".equals(op)) {
			//调用删除多个的方法
			delAllInvitation(req,resp);
			list=is.getall();
			req.getSession().setAttribute("invitation", list);
		}else if("update".equals(op)) {
			//调用修改数据的方法
			updateInvitation(req,resp);
			list=is.getall();
			req.getSession().setAttribute("invitation", list);
		}else if("like".equals(op)) {
			//调用模糊查询数据的方法
			getInvitation(req,resp);
		}else if("show".equals(op)) {
			//调用模糊查询数据的方法
			showInvitation(req,resp);
		}else if("audit".equals(op)) {
			//调用审核的方法
			auditInvitation(req,resp);
		}
	}
	//审核评论
	private void auditInvitation(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面的数据
		String id=req.getParameter("id");
		PrintWriter out;
		try {
			out = resp.getWriter();
			boolean isOk = is.isPass(id);
			if(isOk) { 
				out.write("true"); 
				     }
			else { 
					out.write("false"); 
				}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	//展示主贴跟回帖信息
	private void showInvitation(HttpServletRequest req, HttpServletResponse resp) {
		String id=req.getParameter("id");
		Invitation intion=is.getByid(id);
		List<InvitationAns> in_ans=iss.getById(id);
		try {
			req.getSession().setAttribute("intion",intion);
			req.getSession().setAttribute("in_ans",in_ans);
			req.getRequestDispatcher("/server/invitation_ans.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//修改主贴
	private void updateInvitation(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			String id = req.getParameter("invitationId");
			String message = req.getParameter("message");
			int plateid =Integer.parseInt( req.getParameter("plateId"));
			int categoryid = Integer.parseInt(req.getParameter("categoryId"));
			Invitation in=new Invitation(id, message, plateid, categoryid, DButils.getDate());
			boolean isOk = is.updateInvitation(in);
			if(isOk) {
				out.write("true");
			}else {
				out.write("false");
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//模糊查询
	private void getInvitation(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面数据
		String id=req.getParameter("invitationid");
		//调用模糊查询的方法
		List<Invitation> invitation=null;
		if(id=="" ||"".equals(id)) {
			invitation=is.getall();
		}else {
			invitation=is.getInvitationById(id);
		}
		try {
			//报存到作用域
			req.getSession().setAttribute("invitation", invitation);
			//页面跳转
			req.getRequestDispatcher("/server/invitation-list.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//删除单个
    private void delInvitation(HttpServletRequest req, HttpServletResponse resp) {
    	//接收页面的数据
		String id=req.getParameter("id");
		PrintWriter out;
		try {
			out = resp.getWriter();
			boolean isOk = is.delInvitation(id);
			if(isOk) { 
				out.write("true"); 
				     }
			else { 
					out.write("false"); 
				}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
    //查找主贴
	private void getByIdInvitation(HttpServletRequest req, HttpServletResponse resp) {
		String invitationId = req.getParameter("invitationId");
		Invitation tion = is.getByid(invitationId);
			req.getSession().setAttribute("tion", tion);
			try {
				req.getRequestDispatcher("server/invitation-edit.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
    //删除多个
	private void delAllInvitation(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面的数据
		String id=req.getParameter("id");
		String params[]=id.split(",");
		PrintWriter out;
		try {
			out = resp.getWriter();
			boolean isOk = is.delAllInvitation(params);
			if(isOk) { 
				out.write("true"); 
				     }
			else { 
					out.write("false"); 
				}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	//增加主贴
	private void addInvitation(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out;
		//接收页面数据
		String message=req.getParameter("message");
		String plateid=req.getParameter("plateId");
		String categoryId=req.getParameter("categoryId");
		String userid=(String) req.getSession().getAttribute("name");//账号
		String invitationid=userid+DButils.GetId();	
		//创建一个invitation实体对象
		Invitation in=new Invitation(invitationid, message, userid, Integer.parseInt(plateid), Integer.parseInt(categoryId),DButils.getDate());
	    boolean isOK=is.addInvitation(in);
	    try {
			out = resp.getWriter();
			if(isOK) { 
				   out.write("true"); 
				     }
			else { 
					out.write("false"); 
				}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
