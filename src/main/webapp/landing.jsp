<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Beans.MemberDTO"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>리뷰확인</title>
		<style type="text/css">
			td{
				border: 1px solid #ccc;
			}
			img{
				width:300px;
				height:300px;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
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
			<div id="img">
				<c:forEach items="${imglist }" var="imglist">
					<img src="${imglist.getImageurl() }" alt="noImage">
				</c:forEach>
			</div>
		</div>
	</body>
</html>