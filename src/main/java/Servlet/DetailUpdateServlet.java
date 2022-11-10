package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.util.*;

import Beans.detailDTO;
import DAO.detailDAO;


@WebServlet("/DetailUpdate")
public class DetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number=request.getParameter("number");
		
		detailDAO dao=detailDAO.getInstance();
		List<detailDTO> details=dao.selectDetailPage(number);
		
		request.setAttribute("details", details);
		request.getRequestDispatcher("detailUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context=getServletContext();
		String path=context.getRealPath("/img");
		
		String encType="utf-8";
		int sizeLimit=20*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		int number=Integer.parseInt(multi.getParameter("number"));
		String shortpage=multi.getParameter("shortpage");
		String detailpage=multi.getParameter("detailpage");
		String api_latitude=multi.getParameter("api_latitude");
		String api_longitude=multi.getParameter("api_longitude");
		String imageurl="img/"+multi.getFilesystemName("imageurl");
		if(multi.getFilesystemName("imageurl")==null) {
			imageurl=multi.getParameter("nomakeImg");
		}
		detailDTO DTO=new detailDTO();
		DTO.setNumber(number);
		DTO.setShortpage(shortpage);
		DTO.setDetailpage(detailpage);
		DTO.setApi_latitude(api_latitude);
		DTO.setApi_longitude(api_longitude);
		DTO.setImageurl(imageurl);
		
		detailDAO DAO=detailDAO.getInstance();
		DAO.detailUpdate(DTO);
		
		response.sendRedirect("PlaceServlet");
	}

}
