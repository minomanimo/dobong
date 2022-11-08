package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.detailDTO;
import DAO.detailDAO;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Main Get 실행");	//main/detail.jsp 모두 디테일서블렛 이용XX 디스패쳐2개를 쓸수가 없다!!!!!!!!!!!!!
		detailDAO DAO=detailDAO.getInstance();
		
		List<detailDTO> shortpage=DAO.selectShortpage();
		System.out.println("대분류 "+shortpage);
		
		request.setAttribute("shortpage", shortpage);
		RequestDispatcher dis=request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
