package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.NoticeDTO;
import DAO.NoticeDAO;


@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 호출 searchServlet");
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("select");
		String text=request.getParameter("searchValue");
		
		NoticeDAO dao=NoticeDAO.getInstance();
		ArrayList<NoticeDTO> search=dao.getSearch(type, text);
		request.setAttribute("search", search);
		RequestDispatcher dis= request.getRequestDispatcher("search.jsp");
		dis.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
