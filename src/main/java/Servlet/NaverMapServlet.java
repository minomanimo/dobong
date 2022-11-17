package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.*;

@WebServlet("/NaverMap")
public class NaverMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientId="bm5xtq2mgp";
		String clientSecret="NagLpPRbfJFnNVtlo9zAD0K4Wfya4jD3zu7lfgu1";
		String surl="https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
		URL url=new URL(surl);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
		con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
		
		
		int responseCode=con.getResponseCode();
		BufferedReader br;
		if(responseCode==200) {
			br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		}else {
			br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer buffer=new StringBuffer();
		while((inputLine=br.readLine())!=null) {
			buffer.append(inputLine);
		}
		br.close();
		System.out.println(buffer.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
