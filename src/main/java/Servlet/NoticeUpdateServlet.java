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


@WebServlet("/NoticeUpdateServlet")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String number=request.getParameter("number");
		System.out.println("NoticeUpdateServlet GET"+number);
		//String title=request.getParameter("title");
		//String content=request.getParameter("content");
		
		NoticeDAO dao=NoticeDAO.getInstance();
		NoticeDTO dto=dao.selectContent(number);
		System.out.println("데이터확인용 "+dto.getTitle());
		
		request.setAttribute("noticeList", dto);
		RequestDispatcher dis=request.getRequestDispatcher("noticeUpdate.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeUpdateServlet POST");
		request.setCharacterEncoding("UTF-8");
		
		String number=request.getParameter("number");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		NoticeDTO dto=new NoticeDTO();
		dto.setNumber(number);
		dto.setTitle(title);
		dto.setContent(content);
		NoticeDAO dao=NoticeDAO.getInstance();
		dao.updateNoice(dto);
		response.sendRedirect("NoticeServlet");	//바로 리스트 서블렛으로 이동 
		
		
	}

}
