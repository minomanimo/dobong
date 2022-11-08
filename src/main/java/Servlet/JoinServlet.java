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

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinServlet GET");
		//회원가입 정보 확인하기 위해
		RequestDispatcher dis =request.getRequestDispatcher("/register.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinServlet POST");
		request.setCharacterEncoding("utf-8");
		//페이지에서 읽은 회원정보를 받아오는 곳!
		//id와 이메일이 동일하기 때문에 parameter email로 통일
		String id=request.getParameter("email");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String tos1;//=request.getParameter("tos1");
		String tos2;//=request.getParameter("tos2");
		String meter=request.getParameter("meter");
		String category;
		System.out.println(name);
		
		
		MemberDTO m= new MemberDTO();
		//====약관관련 내용 벨류s 값넣어주는 세팅=======
		//2번째 약관은 마케팅조항으로 2라면 광고를 보낼 수 없게 세팅
		String[] tos=request.getParameterValues("tos");
		String tos_check1="1";
		String tos_check2="2";
		for (int i = 0; i < tos.length; i++) {
			if(tos.length!=0) {
				if(tos[0].equals(tos_check1)) {
					tos1=tos[0];
					m.setTos1(tos1);//여기서 바로 값 넣어주기
				}
				if(tos[1].equals(tos_check2)) {
					tos2=tos[1];
					m.setTos2(tos2);//여기서 바로 값 넣어주기
				}	
			}else {
				String msg="약관 미동의로 회원가입 불가";
				System.out.println(msg);
				request.setAttribute("tos_msg", msg);
			}
		}
		
		//====회원 등급 일반회원 1, 관리자 0으로 세팅 이후 관리자페이지에서 변경====
//		String general="1";
//		category=general;
		
		
		//멤버정보 객체에 정보넣기
		m.setId(id);
		m.setName(name);
		m.setNickname(nickname);
		m.setPassword(password);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		//m.setTos2(tos2);
		m.setMeter(meter);
		m.setAdmin(0);
		
		//정보확인
		//System.out.println(m);
		
		MemberDAO mDAO=MemberDAO.getInstance();
		int result=mDAO.insertMember(m);
		
		HttpSession session=request.getSession();//세션으로 로그인 정보를 공유하기 위해 생성
		//1이면 회원가입 성공(DAO가 1을 리턴함)
		if(result==1) {
			session.setAttribute("id", m.getId()); //세션전체에 setting
			request.setAttribute("msg", "회원가입성공");	// 로그인 화면에 나타나지 말고 js 알럿처리 부탁드립니다.  
			System.out.println("회원 가입 성공");
		}else {
			request.setAttribute("msg", "회원가입 실패");
		}
		//회원가입후 다음에 갈 페이지 세팅 → 회원가입 후 로그인 할수 있도록 로그인 서블렛으로 이동
//		RequestDispatcher dis=request.getRequestDispatcher("loginServlet");
		RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
	}
	

}//c
