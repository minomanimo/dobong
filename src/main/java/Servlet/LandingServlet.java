package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import Beans.*;
import DAO.MainDAO;
import Beans.detailDTO;
import DAO.detailDAO;



@WebServlet("/LandingServlet")
public class LandingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("main Get 실행");
		MainDAO DAO=MainDAO.getInstance();
		
		detailDAO dDAO=detailDAO.getInstance();
		
		
		List<ImageDTO> imglist=DAO.getLandmarkImg();
		
		List<detailDTO> shortpage=dDAO.selectShortpage();
		List<detailDTO> details=dDAO.selectAllDetail();
		System.out.println("대분류 "+shortpage);
		
		request.setAttribute("imglist", imglist);
		request.setAttribute("shortpage", shortpage);
		request.setAttribute("details",details);
		
		request.getRequestDispatcher("landing.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
