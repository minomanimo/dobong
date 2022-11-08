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
		String shortPage=request.getParameter("shortpage");
				
		
		detailDTO rDTO=new detailDTO();
		rDTO.setTextminning1(review); //일단 리뷰 1개만 텍스트1에 넣음
		rDTO.setTextminning2(review); //일단 리뷰 1개만 텍스트1에 넣음
		rDTO.setTextminning3(review); //일단 리뷰 1개만 텍스트1에 넣음
		rDTO.setTextminning4(review); //일단 리뷰 1개만 텍스트1에 넣음
		rDTO.setNumber(number);
		rDTO.setShortpage(shortPage);
		
		System.out.println(rDTO+" rDTO 리뷰확인");
		detailDAO rDAO=detailDAO.getInstance();
		rDAO.UpdateReview(rDTO);
		
//		request.setAttribute("review", rDTO);	//리뷰를 키로 dDTO 보냄
		request.setAttribute("detail", rDTO);	//리뷰를 키로 dDTO 보냄
		RequestDispatcher dis=request.getRequestDispatcher("MainServlet");
		dis.forward(request, response);
		//메인서블릿으로가면 디테일 페이지가 나오는데 바로 디테일서블렛으로 갈 수 없음 
		//response.sendRedirect("");	
	}

}
