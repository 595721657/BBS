package controller.invitation_ans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.InvitationAns;
import service.invitation_ans.impl.Invitation_ansServiceImpl;
import utils.DButils;
@WebServlet("/Invitation_ans")
public class Invitation_ansServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5699797368938303365L;
    private Invitation_ansServiceImpl iss=new Invitation_ansServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		//����ҳ�洫�ݹ����Ĳ���
		String op=req.getParameter("op");
		//�ж�op��ֵ
		if("add".equals(op)) {
			//�������ӵķ���
			addInvitation_ans(req,resp);
		}
	}
    //���ӻ���
	private void addInvitation_ans(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out;
		// ��������
		String id=req.getParameter("id");
		String name=(String) req.getSession().getAttribute("name");
		String message=req.getParameter("contents");
		String ansid=name+DButils.GetId();
		InvitationAns ins=new InvitationAns(ansid, message, id, name, DButils.getDate());
		boolean isOK=iss.addInvitation_ans(ins);
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
