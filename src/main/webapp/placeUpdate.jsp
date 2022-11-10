<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>장소 수정</title>
	</head>
	<body>
		<div id="wrap">
			<h1>장소 수정</h1>
			<c:forEach items="${shortpage }" var="shortpage">
				<ul>
					<li>${shortpage.getShortpage() }</li>
					<c:forEach items="${details }" var="details">
					 	<c:if test="${shortpage.getShortpage() eq  details.getShortpage()}">
					 		<td><a href="DetailUpdate?number=${details.getNumber() }">${details.getDetailpage() }</a></td>
					 	</c:if>
					 </c:forEach>
				</ul>
			</c:forEach>
			<div id="insert">
				<h1>장소 추가</h1>
				<form method="post" enctype="multipart/form-data" name="frm" action="PlaceServlet">
					<table>
						<tr>
							<th>대분류</th>
							<td><input type="text" name="shortpage"></td>
						</tr>
						<tr>
							<th>소분류</th>
							<td><input type="text" name="detailpage"></td>
						</tr>
						<tr>
							<th>위도</th>
							<td><input type="text" name="api_latitude"></td>
						</tr>
						<tr>
							<th>경도</th>
							<td><input type="text" name="api_longitude"></td>
						</tr>
						<tr>
							<th>이미지</th>
							<td><input type="file" name="imageurl"></td>
						</tr>
					</table>
					<input type="submit" value="추가">
				</form>
			</div>
		</div>
	</body>
</html>