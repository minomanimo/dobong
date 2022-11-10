package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Beans.detailDTO;
import DAO.detailDAO;

@WebServlet("/PlaceServlet")
public class PlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		detailDAO DAO=detailDAO.getInstance();
		
		List<detailDTO> shortpage=DAO.selectShortpage();
		List<detailDTO> details=DAO.selectAllDetail();
		
		request.setAttribute("shortpage", shortpage);
		request.setAttribute("details", details);
		
		request.getRequestDispatcher("placeUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context=getServletContext();
		String path=context.getRealPath("/img");
		
		String encType="utf-8";
		int sizeLimit=20*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		
		String shortpage=multi.getParameter("shortpage");
		String detailpage=multi.getParameter("detailpage");
		String api_latitude=multi.getParameter("api_latitude");
		String api_longitude=multi.getParameter("api_longitude");
		String imageurl="img/"+multi.getFilesystemName("imageurl");
		
		detailDTO DTO=new detailDTO();
		
		DTO.setShortpage(shortpage);
		DTO.setDetailpage(detailpage);
		DTO.setApi_latitude(api_latitude);
		DTO.setApi_longitude(api_longitude);
		DTO.setImageurl(imageurl);
		
		detailDAO DAO=detailDAO.getInstance();
		DAO.detailInsert(DTO);
		
		
		response.sendRedirect("PlaceServlet");
	}

}
