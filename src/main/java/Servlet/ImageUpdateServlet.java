package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.MainDAO;
import Beans.*;


@WebServlet("/ImageUpdate")
public class ImageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainDAO DAO=MainDAO.getInstance();
		List<ImageDTO> imglist=DAO.getLandmarkImg();
		
		request.setAttribute("imglist", imglist);
		
		request.getRequestDispatcher("landmarkUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context=getServletContext();
		String path=context.getRealPath("/landmark");
		
		String enctype="utf-8";
		int sizeLimit=20*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(request,path,sizeLimit,enctype,new DefaultFileRenamePolicy());
		
		List<ImageDTO> imglist=new ArrayList<>();
		ImageDTO DTO;
		for(int i=0; i<8; i++) {
			DTO=new ImageDTO();
			String url="landmark/"+multi.getFilesystemName("imageurl"+i);;
			if(multi.getFilesystemName("imageurl"+i)==null) {
				url=multi.getParameter("noUpdate"+i);
			}
			DTO.setImageurl(url);
			DTO.setNumber(Integer.parseInt(multi.getParameter("number"+i)));
			imglist.add(DTO);
		}
		
		MainDAO DAO=MainDAO.getInstance();
		DAO.setLandmarkImg(imglist);
		
		this.doGet(request, response);
	}

}
