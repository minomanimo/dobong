package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.NoticeDTO;
import DAO.NoticeDAO;


@WebServlet("/NoticeContentServlet")
public class NoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		String number=request.getParameter("number");
		System.out.println("NoticeContentServlet() Get"+number);
		NoticeDAO DAO=NoticeDAO.getInstance();
		NoticeDTO DTO=DAO.selectContent(number);
		System.out.println("데이터 확인"+DTO.getNumber());
		
		request.setAttribute("content", DTO);
		RequestDispatcher dis=request.getRequestDispatcher("noticeContent.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeContentServlet() Post");
	}

}
