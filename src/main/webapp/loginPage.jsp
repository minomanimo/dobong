<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>공지사항</title>
		<style type="text/css">
			h1{
				display: inline-block;
			}
		</style>
	</head>
	<body>
		<h1>${loginUser.name }님 안녕하세요 </h1> 
		<form action="LogoutServlet" method="get">
			<input type="submit" value="로그아웃">
		</form>
		<a href="memberUpdate?userid=${loginUser.id }">회원정보수정</a><br>
	</body>
</html>