package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import DAO.detailDAO;


@WebServlet("/DetailDelete")
public class DetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number=Integer.parseInt(request.getParameter("number"));
		
		detailDAO DAO=detailDAO.getInstance();
		DAO.detailDelete(number);
		
		response.sendRedirect("PlaceServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
