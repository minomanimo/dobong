package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import DAO.MemberDAO;
import Beans.*;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		MemberDAO m=MemberDAO.getInstance();
		ArrayList<MemberDTO> mList=m.getAllMember(currentPage);
		request.setAttribute("mList", mList);
		
		int row=m.memberCount();
		int nOfPage=row/20;
		if(row%20>0) {
			nOfPage++;
		}
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("nOfPage", nOfPage);
		RequestDispatcher dis=request.getRequestDispatcher("members.jsp");
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
