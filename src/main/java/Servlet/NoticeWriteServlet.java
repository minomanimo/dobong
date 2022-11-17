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


//공지사항 글쓰기 써블릿
@WebServlet("/NoticeWriteServlet")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("NoticeWriteServlet GET");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeWriteServlet POST");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		System.out.println("*****"+id);
		//String password=request.getParameter("password");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		//페이지에서 받아온 값을 객체에 넣어줌
		NoticeDTO n=new NoticeDTO();
		n.setNickname(id);
		//n.setPassword(password);
		
		n.setTitle(title);
		n.setContent(content);
		
	
		NoticeDAO nDAO=NoticeDAO.getInstance();
		int result=nDAO.insertNoice(n);
		System.out.println("insert 확인 용 "+result);
		
		//request.setAttribute("check", "글쓰기 완료");

		//로그인 상관없이 글쓰기 
		//RequestDispatcher dis=request.getRequestDispatcher("/checkPage/noticeCheck.jsp");	//체크안하고 바로 값 얻은다음에 notice로 전달
		response.sendRedirect("NoticeServlet");//서블릿으로 바로 보내기
//		RequestDispatcher dis=request.getRequestDispatcher("notice.jsp");
		//dis.forward(request, response);
	}

}//c
