<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>관리자 페이지</title>
		<link rel="icon" href="images/icon1.ico">
		<style>
			td{
				border:1px solid black;
			}
			li{
				list-style:none;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<h1>관리자 페이지</h1>
			<a href="AdminServlet">회원 정보</a><br>
			<a href="PlaceServlet">장소 수정</a><br>
			<a href="ImageUpdate">랜드마크 이미지 수정</a><br>
			<a href="noticeWrite.jsp">공지사항 글쓰기</a><br>
			<a href="index.jsp">홈으로</a>
		</div>
	</body>
</html>