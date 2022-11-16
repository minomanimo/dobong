package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.detailDTO;
import DAO.detailDAO;

//리뷰 글쓰기 서블릿
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		String txtResult=request.getParameter("stars");
//		String review=request.getParameter("review");
//		System.out.println(txtResult);
//		System.out.println(review);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReviewServlet Post 실행");
		request.setCharacterEncoding("utf-8");
		
		String review= request.getParameter("review");
		int number=Integer.parseInt(request.getParameter("number"));
		
		
		detailDAO dao=detailDAO.getInstance();
		int success=dao.setTextmining(review, number);
		
//		request.setAttribute("review", rDTO);	//리뷰를 키로 dDTO 보냄
		response.sendRedirect("detailServlet?number="+number);
		
	}

}
