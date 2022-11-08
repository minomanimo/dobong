package Servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.NoticeDTO;
import DAO.NoticeDAO;


@WebServlet("/NoticePageServlet")
public class NoticePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticePageServlet() POST 실행");
		request.setCharacterEncoding("utf-8");
		
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int recordsPerPage=Integer.parseInt(request.getParameter("recordsPerPage"));
	//	int number=Integer.parseInt(request.getParameter("number"));
		
		NoticeDAO DAO=NoticeDAO.getInstance();
		ArrayList<NoticeDTO> noticeList=DAO.findList(currentPage, recordsPerPage);
		System.out.println(noticeList+"******");
		
		int row= DAO.getNumOfRows();
		int nOfpage=row/recordsPerPage;
		
		if(row%recordsPerPage>0) {
			nOfpage++;
		}
		request.setAttribute("data", noticeList);
		request.setAttribute("nOfPage", nOfpage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("recordsPerPage", recordsPerPage);
		RequestDispatcher dis=request.getRequestDispatcher("noticePage.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
