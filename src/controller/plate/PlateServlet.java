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
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
        if("add".equals(op)) {
        	//调用增加板块的方法
        	addPlate(req,resp);
        }else if("del".equals(op)) {
        	//调用删除单个的方法
        	delPlate(req,resp);
        }else if("delall".equals(op)) {
        	//调用删除多个的方法
        	delAllPlate(req,resp);
        }else if("update".equals(op)) {
        	//调用修改的方法
        	updatePlate(req,resp);
        }else if("plateid".equals(op)) {
        	//调用通过id查询数据的方法
        	getByid(req,resp);
        }else if("platetitle".equals(op)) {
        	//调用模糊查询的方法
        	getBytitle(req,resp);
        }else if("enable".equals(op)) {
        	//调用禁用的方法
        	Disable(req,resp);
        }
        
	}
	//禁用板块的方法
	private void Disable(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面的数据
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

	//通过板块标题查询数据的方法
	private void getBytitle(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面数据
		String platetitle=req.getParameter("plateTitle");
		//调用模糊查询的方法
		List<Plate> plate=null;
		if(platetitle=="" ||"".equals(platetitle)) {
			plate=ps.getAllPlate();
		}else {
			plate=ps.getAllBytitlePlate(platetitle);
		}
		try {
			//报存到作用域
			req.getSession().setAttribute("plate", plate);
			//页面跳转
			req.getRequestDispatcher("/server/plant-list.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//通过plateid查询数据的方法
	private void getByid(HttpServletRequest req, HttpServletResponse resp) {
		String plateid=req.getParameter("plantid");
		//调用通过plateid查询d方法
		Plate plate=ps.getByPlateid(Integer.parseInt(plateid));
		try {
			//报存到作用域
			req.getSession().setAttribute("plates", plate);
			//页面跳转
			req.getRequestDispatcher("/server/plant-edit.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//修改板块的方法
	private void updatePlate(HttpServletRequest req, HttpServletResponse resp) {
		// 接收页面数据
        int plateid=Integer.parseInt(req.getParameter("plateid"));
        String title=req.getParameter("platetitle");
        String message=req.getParameter("platemessage");
        Plate plate=new Plate();
        plate.setPlateid(plateid);
        plate.setPlatetitle(title);
        plate.setPlatemessage(message);
		//调用修改的方法
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

	//删除多个板块
	private void delAllPlate(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面的数据
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

	//删除单个板块
	private void delPlate(HttpServletRequest req, HttpServletResponse resp) {
		//接收页面的数据
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
    //增加板块的方法
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
