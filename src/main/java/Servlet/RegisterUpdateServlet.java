package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.MemberDTO;
import DAO.MemberDAO;


@WebServlet("/RegisterUpdateServlet")
public class RegisterUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//loginpage에서 회원정보수정버튼 누른 후 회원정보 값 매칭→ memberUpdate.jsp 값 전달
		System.out.println("GET RegisterUpdate");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("userid");	//get방식에서는 ?뒤에 있는 값을 name으로 받아온다
		
		MemberDAO dao=MemberDAO.getInstance();
		MemberDTO dto=dao.getMember(id);
		request.setAttribute("members", dto);
		RequestDispatcher dis=request.getRequestDispatcher("memberUpdate.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업데이트 성공 1/실패 0 
		System.out.println("POST RegisterUpdate");
		request.setCharacterEncoding("utf-8");
		
		int number=Integer.parseInt(request.getParameter("number")); 
		String id=request.getParameter("id");
		String nickname=request.getParameter("nickname");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String tos1=request.getParameter("tos1");
		String tos2=request.getParameter("tos2");
		String meter=request.getParameter("meter");
		int admin=Integer.parseInt(request.getParameter("admin"));
		
		MemberDTO dto=new MemberDTO();
		dto.setNumber(number);
		dto.setId(id);
		dto.setNickname(nickname);
		dto.setName(name);
		dto.setPassword(password);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setAddress(address);
		dto.setTos1(tos1);
		dto.setTos2(tos2);
		dto.setMeter(meter);
		dto.setAdmin(admin);
		
		
		MemberDAO dao=MemberDAO.getInstance();
		//업데이트 성공 1/실패 0 
		int res=dao.updateRegister(dto);
		if(res==1) {
			System.out.println("성공 "+res);
		}else {
			System.out.println("실패 "+res);
		}
		response.sendRedirect("NoticeServlet");
	}
}



