<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Beans.MemberDTO"  %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>리뷰확인</title>
		<style type="text/css">
			td{
				border: 1px solid #ccc;
			}
		</style>
	</head>
	<body>
	<% 	
		MemberDTO m=null;
		if(session.getAttribute("loginUser")!=null){
			m=(MemberDTO)session.getAttribute("loginUser");
		}
	%>
		<a href="NoticeServlet">공지사항</a> <br>
		<!-- <a href="detailServlet">상세페이지</a> <br> -->
		<a href="MainServlet">대분류</a><br>
		
		<a href="noticeWrite.jsp">글쓰기</a><br>
	<%
		if(m==null){
	%>
			<a href="login.jsp">로그인</a><br>
			<a href="join.jsp">회원가입</a><br>
	<%		
		}
	%>
		
	<%
		if(m!=null){
	%>
			<a href="LogoutServlet">로그아웃</a><br>
	<%
			if(m.getAdmin()==1){
	%>
			<a href="adminPage.jsp">관리자 페이지</a>
	<%		
			}
		}
	%>	
			
	</body>
</html>