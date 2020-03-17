package controller.plate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Plate;
import service.plant.impl.PlantServiceImpl;
@WebServlet("/PlantServlet")
public class PlateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4371193100892558838L; 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
        if("add".equals(op)) {
        	//�������Ӱ��ķ���
        	addPlate(req,resp);
        }else if("del".equals(op)) {
        	//����ɾ�������ķ���
        	delPlate(req,resp);
        }else if("delall".equals(op)) {
        	//����ɾ������ķ���
        	delAllPlate(req,resp);
        }else if("update".equals(op)) {
        	//�����޸ĵķ���
        	updatePlate(req,resp);
        }else if("plateid".equals(op)) {
        	//����ͨ��id��ѯ���ݵķ���
        	getByid(req,resp);
        }else if("platetitle".equals(op)) {
        	//����ģ����ѯ�ķ���
        	getBytitle(req,resp);
        }else if("enable".equals(op)) {
        	//���ý��õķ���
        	Disable(req,resp);
        }
        
	}
	//���ð��ķ���
	private void Disable(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ�������
		int plateId=Integer.parseInt(req.getParameter("id"));
		Plate plate=ps.getByPlateid(plateId);
		int isable=0;
		if(plate.getIsenable()==0) {
			isable=1;
		}else {
			isable=0;
		}
		 PrintWriter out;
			try {
				out = resp.getWriter();
				boolean isOk = ps.IsEnable(isable, plateId);
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

	//ͨ���������ѯ���ݵķ���
	private void getBytitle(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ������
		String platetitle=req.getParameter("plateTitle");
		//����ģ����ѯ�ķ���
		List<Plate> plate=null;
		if(platetitle=="" ||"".equals(platetitle)) {
			plate=ps.getAllPlate();
		}else {
			plate=ps.getAllBytitlePlate(platetitle);
		}
		try {
			//���浽������
			req.getSession().setAttribute("plate", plate);
			//ҳ����ת
			req.getRequestDispatcher("/server/plant-list.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ͨ��plateid��ѯ���ݵķ���
	private void getByid(HttpServletRequest req, HttpServletResponse resp) {
		String plateid=req.getParameter("plantid");
		//����ͨ��plateid��ѯd����
		Plate plate=ps.getByPlateid(Integer.parseInt(plateid));
		try {
			//���浽������
			req.getSession().setAttribute("plates", plate);
			//ҳ����ת
			req.getRequestDispatcher("/server/plant-edit.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//�޸İ��ķ���
	private void updatePlate(HttpServletRequest req, HttpServletResponse resp) {
		// ����ҳ������
        int plateid=Integer.parseInt(req.getParameter("plateid"));
        String title=req.getParameter("platetitle");
        String message=req.getParameter("platemessage");
        Plate plate=new Plate();
        plate.setPlateid(plateid);
        plate.setPlatetitle(title);
        plate.setPlatemessage(message);
		//�����޸ĵķ���
        PrintWriter out;
		try {
			out = resp.getWriter();
			boolean isOk = ps.updatePlate(plate);
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

	//ɾ��������
	private void delAllPlate(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ�������
		String id=req.getParameter("id");
		String params[]=id.split(",");
		PrintWriter out;
		try {
			out = resp.getWriter();
			boolean isOk = ps.delAllPlate(params);
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

	//ɾ���������
	private void delPlate(HttpServletRequest req, HttpServletResponse resp) {
		//����ҳ�������
		String id=req.getParameter("id");
		PrintWriter out;
		try {
			out = resp.getWriter();
			boolean isOk = ps.delPlate(Integer.parseInt(id));
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
	
	private PlantServiceImpl ps=new PlantServiceImpl();
    //���Ӱ��ķ���
	private void addPlate(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			Plate plate=new Plate();
			String title=req.getParameter("plateTitle");
			String message=req.getParameter("plateMessage");
			plate.setPlatetitle(title);
			plate.setPlatemessage(message);
			boolean isOk = ps.addPlate(plate);
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
	

}
