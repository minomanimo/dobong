package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/NaverMapRv")
public class NaverMapRvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/xml");
		String clientId="bm5xtq2mgp";
		String clientSecret="NagLpPRbfJFnNVtlo9zAD0K4Wfya4jD3zu7lfgu1";
		String coord=request.getParameter("coord");
		String surl="https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords="+coord+"&output=json&orders=addr,roadaddr";
		try {
			URL url=new URL(surl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			
			int responseCode=conn.getResponseCode();
			BufferedReader br;
			if(responseCode==200) {
				br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			}else {
				br=new BufferedReader(new InputStreamReader(conn.getErrorStream(),"utf-8"));
			}
			String line;
			StringBuffer sb=new StringBuffer();
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
//			System.out.println(sb.toString());
			PrintWriter out=response.getWriter();
			out.println("<response>");
			out.println("<data>"+sb.toString()+"</data>");
			out.println("</response>");
			out.close();
		}catch(Exception e) {
			System.out.println("오류발생 : "+e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
