package Servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Beans.MemberDTO;
import DAO.MemberDAO;



@WebServlet("/ChangeAdminServlet")
public class ChangeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int admin=Integer.parseInt(request.getParameter("admin"));
		MemberDAO m=MemberDAO.getInstance();
		m.changeAdmin(id,admin);
		ArrayList<MemberDTO> mList=m.getAllMember();
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("adminPage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
