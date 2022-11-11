package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import Beans.*;
import DAO.MainDAO;



@WebServlet("/LandingServlet")
public class LandingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainDAO DAO=MainDAO.getInstance();
		List<ImageDTO> imglist=DAO.getLandmarkImg();
		
		request.setAttribute("imglist", imglist);
		request.getRequestDispatcher("landing.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
