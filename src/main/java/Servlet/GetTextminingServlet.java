package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import DAO.detailDAO;
import Beans.*;


@WebServlet("/GetTextmining")
public class GetTextminingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/xml");
		int number=Integer.parseInt(request.getParameter("number"));
		
		detailDAO dao=detailDAO.getInstance();
		List<tmDTO> tlist=dao.getTextmining(number);
		
		PrintWriter out=response.getWriter();
		
		out.println("<response>");
		for(int i=0; i<tlist.size(); i++){
			out.println("<text>"+tlist.get(i).getText()+"</text>");
			out.println("<count>"+tlist.get(i).getCount()+"</count>");
		}
		out.println("</response>");
		out.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
