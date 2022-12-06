<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>랜드마크 이미지 수정</title>
		<!-- 아이콘 -->
		<link rel="icon" href="images/icon1.ico">
		<style>
			img{
				width:150px;
				height:150px;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<h1>랜드마크 이미지 수정</h1>
			<form method="post" enctype="multipart/form-data" name="frm" action="ImageUpdate">
				<table>
					<c:forEach begin="0" end="7" var="i">
						<tr>
							<td>
								<img src="${imglist.get(i).getImageurl() }" alt="noImg">
							</td>
							<td>
								<input type="file" name="imageurl${i }">
								<input type="hidden" name="number${i }" value="${imglist.get(i).getNumber() }">
								<input type="hidden" name="noUpdate${i }" value="${imglist.get(i).getImageurl() }">
							</td>
						</tr>
					</c:forEach>
				</table>
				
				<input type="submit" value="수정">
			</form>
			<a href="adminPage.jsp">관리자 페이지</a>
		</div>
	</body>
</html>