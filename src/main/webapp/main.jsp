<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>메인</title>
	</head>
	<body>
	<h1>${shortpage[3].shortpage}</h1>
	<!--대분류 메뉴-->
		<table>
			<c:forEach items="${shortpage }" var="shortpage"> 
				<tr>
					 <td> <a href="detailServlet?shortpage=${shortpage.getShortpage()}"> ${shortpage.getShortpage() } </a ></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 메뉴-->	
	</body>
</html>