package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import Beans.*;
import DAO.detailDAO;


@WebServlet("/GetLatlng")
public class GetLatlng extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/xml");
		
		String number=request.getParameter("number");
		detailDAO dao=detailDAO.getInstance();
		List<detailDTO> list=dao.selectDetailPage(number);
		detailDTO dto=list.get(0);
		
		PrintWriter out=response.getWriter();
		
		out.println("<response>");
		out.println("<lat>"+dto.getApi_latitude()+"</lat>");
		out.println("<lng>"+dto.getApi_longitude()+"</lng>");
		out.println("</response>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
