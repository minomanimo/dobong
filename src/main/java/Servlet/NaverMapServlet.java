package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.*;

import org.json.simple.*;
import org.json.simple.parser.*;

@WebServlet("/NaverMap")
public class NaverMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param=request.getParameter("address");
		String clientId="bm5xtq2mgp";
		String clientSecret="NagLpPRbfJFnNVtlo9zAD0K4Wfya4jD3zu7lfgu1";
		String addr=URLEncoder.encode(param, "utf-8");
		String surl="https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr;
		
		try {
			URL url=new URL(surl);
			
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
//			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			
			
			int responseCode=con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) {
				br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
				
			}else {
				br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer buffer=new StringBuffer();
			while((inputLine=br.readLine())!=null) {
				buffer.append(inputLine);
				
			}
	
			
//			System.out.println(buffer.toString());
//			
//			JSONParser parser=new JSONParser();
//			JSONObject obj=(JSONObject)parser.parse(br.toString());
//			JSONArray arr=(JSONArray)obj.get("addresses");
//			JSONObject obj2;
//			String x="";
//			String y="";
//			for(Object o:arr) {
//				obj2=(JSONObject)o;
//				if(obj2.get("x")!=null) x=(String)obj2.get("x");
//				if(obj2.get("y")!=null) y=(String)obj2.get("y");
//			}
//			System.out.println(x+"  "+y);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/xml");
			
			PrintWriter out=response.getWriter();
			out.println("<response>");
			out.println("<data>"+buffer.toString()+"</data>");
			out.println("</response>");
			out.close();
			br.close();
		}catch(Exception e) {
			System.out.println("오류발생 : "+e);
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
