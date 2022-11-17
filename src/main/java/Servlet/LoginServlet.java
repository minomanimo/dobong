package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.MemberDTO;
import DAO.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		request.setCharacterEncoding("utf-8");
		String url="login.jsp";	
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		MemberDAO mDAO=MemberDAO.getInstance();
		int checkLogin=mDAO.userCheck(id, password);
		System.out.println("로그인 결과값 숫자확인: "+checkLogin);
			//1로그인 성공 / 0비번틀림 / -1아이디 없음
		
		if(checkLogin==1) {
			MemberDTO m=mDAO.getMember(id);
			HttpSession session=request.getSession();	//			//세션을 이용하는데 싱글톤패턴 사용(new을 하게되면 계속 세션이 생성되니까) HttpSession 안에 있는 메서드
			session.setAttribute("loginUser", m);
			//url="notice.jsp";	//기본적으로 
			
		}else if(checkLogin==0) {
			request.setAttribute("msg", "비밀번호 불일치");
		}else if(checkLogin==-1) {
			request.setAttribute("msg", "비회원 입니다.");
			url="join.jsp";	//비회원이라 회원가입으로 이동
			//dis=request.getRequestDispatcher(url);
		}
		//RequestDispatcher dis=request.getRequestDispatcher(url);
		//dis.forward(request, response);
		//response.sendRedirect(url);
		
		//바로 공지사항으로 리다이렉트! 성공
		response.sendRedirect("NoticeServlet");//서블릿으로 바로 보내기
		
	}

}
