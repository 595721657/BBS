package controller.plate;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Plate;
import service.plant.impl.PlantServiceImpl;
@WebServlet("/Plates")
public class PlantsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6006330724195501209L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PlantServiceImpl ps=new PlantServiceImpl();
		List<Plate> plate=ps.getAllPlate();
		req.getSession().setAttribute("plate", plate);
		req.getRequestDispatcher("/server/plant-list.jsp").forward(req, resp);
	}

}
