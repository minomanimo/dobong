package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import Beans.*;
import DAO.detailDAO;

import java.util.*;


@WebServlet("/detailServlet")
public class detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String number=request.getParameter("number");
		System.out.println("detail_Get 실행 "+number);	//메인에서 오는 값을 확인함
		
		detailDAO DAO=detailDAO.getInstance();
		List<detailDTO> detail=DAO.selectDetailPage(number); 
		System.out.println(detail+"큰 카테고리확인");	
		
		request.setAttribute("detail", detail);
		RequestDispatcher dis=request.getRequestDispatcher("detail.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST detailServlet 실행");
		this.doGet(request, response);
		//response.sendRedirect("detail.jsp");
		
				
	}
}
