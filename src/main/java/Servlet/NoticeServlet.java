package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import Beans.NoticeDTO;
import DAO.NoticeDAO;

import java.util.*;


@WebServlet("/NoticeServlet")
//웹에 보여지는 내용
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int recordsPerpage = 10;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("NoticeServlet GET 실행");
		NoticeDAO dao=NoticeDAO.getInstance();
		List<NoticeDTO> noticeList=dao.selectAllReview();
		//System.out.println(noticeList);
		request.setAttribute("noticeList", noticeList);
		
		//=============================
		//페이지보기(5,10,15)
		//=============================
		// notice getParameter → 현재페이지와, 페이지 인덱스를 파라미터로 사용 
//		noticeList=dao.findList(currentPage, recordsPerpage);
		System.out.println(noticeList);
		int row= dao.getNumOfRows();
		int nOfPage=row/recordsPerpage;	//전체 게시글/페이지당 글수→ 페이지인덱스을 알수있음 
		
		if(row%recordsPerpage>0) {
			nOfPage++;	//디폴트페이지 세팅보다 크다면 페이지 인덱스 추가(++)
		}
	//	request.setAttribute("noticeList", noticeList);
		request.setAttribute("nOfPage", nOfPage);	//페이지 값을 jsp파일로 리퀘스트
		request.setAttribute("currentPage",1);	//현재 페이지 1
		request.setAttribute("recordsPerPage", 10);	//기본이라 이렇게 넘겼나??
			
		//------자료확인----------
//		System.out.println("총페이지: "+nOfPage);
//		System.out.println("전체자료수 "+row);
		//System.out.println("마지막 페이지 자료: "+ row%recordsPerPage);
		
		
		RequestDispatcher dis=request.getRequestDispatcher("notice.jsp");
		//여기에서 jsp을 보내준다!
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
