<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>수정 페이지</title>
		<style>
			td{
				border:1px solid black;
			}
			img{
				width: 150px;
				height: 150px;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<h1>수정 페이지</h1>
			<form method="post" enctype="multipart/form-data" name="frm" action="DetailUpdate">
				<input type="hidden" name="nomakeImg" value="${details.get(0).getImageurl() }">
				<input type="hidden" name="number" value="${details.get(0).getNumber() }">
				<table>
					
					<tr>
						<td rowspan="5">
							<c:choose>
								<c:when test="${details.get(0).getImageurl() eq '/img/null' }">
									이미지가 없습니다.
								</c:when>
								<c:otherwise>
									<img src="${details.get(0).getImageurl() }">
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<input type="text" name="shortpage" value="${details.get(0).getShortpage() }">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="detailpage" value="${details.get(0).getDetailpage() }">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="api_latitude" value="${details.get(0).getApi_latitude() }">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="api_longitude" value="${details.get(0).getApi_longitude() }">
						</td>
					</tr>
					<tr>
						<td>
							<input type="file" name="imageurl">
						</td>
					</tr>
				</table>
				<input type="submit" value="수정"><br>
				<a href="DetailDelete?number=${details.get(0).getNumber() }">삭제하기</a>
			</form>
		</div>
	</body>
</html>