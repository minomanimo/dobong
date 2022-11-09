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
					 <td>${shortpage.getShortpage() }</td>
					 <c:forEach items="${details }" var="details">
					 	<c:if test="${shortpage.getShortpage() eq  details.getShortpage()}">
					 		<td><a href="detailServlet?number=${details.getNumber() }">${details.getDetailpage() }</a></td>
					 	</c:if>
					 </c:forEach>
				</tr>
			</c:forEach>
		</table>
		<!-- 메뉴-->	
	</body>
</html>