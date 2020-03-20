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
    //����һ��service�����
	InvitationServiceImpl is=new InvitationServiceImpl();
	Invitation_ansServiceImpl iss=new Invitation_ansServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    //���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		List<Invitation> list=null;
		//����ҳ�洫�ݹ����Ĳ���
		String op=req.getParameter("op");
		if("add".equals(op)) {
			//�������ӵķ���
			addInvitation(req,resp);
			list=is.getall();
			req.getSession().setAttribute("invitation", list);
		}else if("findid".equals(op)) {
			//���ò�ѯ�ķ���
			getByIdInvitation(req,resp);
		}else if("del".equals(op)) {
			//����ɾ�������ķ���
			delInvitation(req,resp);
		}else if("delall".equals(op)) {
			//����ɾ������ķ���
			delAllInvitation(req,resp);
			list=is.getall();
			req.getSession().setAttribute("invitation", list);
		}else if("update".equals(op)) {
			//�����޸����ݵķ���
			updateInvitation(req,resp);
			list=is.getall();
			req.getSession().setAttribute("invitation", list);
		}else if("like".equals(op)) {
			//����ģ����ѯ���ݵķ���
			getInvitation(req,resp);
		}else if("show".equals(op)) {
			//����ģ����ѯ���ݵķ���
			showInvitation(req,resp);
		}else if("audit".equals(op)) {
			//������˵ķ���
			auditInvitation(req,resp);
		}
	}
	//�������
	private void auditInvitation(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ�������
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

	//չʾ������������Ϣ
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

	//�޸�����
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

	//ģ����ѯ
	private void getInvitation(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ������
		String id=req.getParameter("invitationid");
		//����ģ����ѯ�ķ���
		List<Invitation> invitation=null;
		if(id=="" ||"".equals(id)) {
			invitation=is.getall();
		}else {
			invitation=is.getInvitationById(id);
		}
		try {
			//���浽������
			req.getSession().setAttribute("invitation", invitation);
			//ҳ����ת
			req.getRequestDispatcher("/server/invitation-list.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ɾ������
    private void delInvitation(HttpServletRequest req, HttpServletResponse resp) {
    	//����ҳ�������
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
    //��������
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
    //ɾ�����
	private void delAllInvitation(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ�������
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

	//��������
	private void addInvitation(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out;
		//����ҳ������
		String message=req.getParameter("message");
		String plateid=req.getParameter("plateId");
		String categoryId=req.getParameter("categoryId");
		String userid=(String) req.getSession().getAttribute("name");//�˺�
		String invitationid=userid+DButils.GetId();	
		//����һ��invitationʵ�����
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
