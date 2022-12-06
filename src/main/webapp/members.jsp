<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원 정보</title>
		<!-- 아이콘 -->
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
			<h1>회원 정보</h1>
			<div id="member">
				<table>
					<tr>
						<th>회원 ID</th>
						<th>이름</th>
						<th>연락처</th>
					</tr>
					<c:forEach items="${mList }" var="mList">
						<tr>
							<td>${mList.getId() }</td>
							<td>${mList.getName() }</td>
							<td>${mList.getAddress() }</td>
							<c:choose>
								<c:when test="${mList.getAdmin()==0 }">
									<td><a href="ChangeAdminServlet?id=${mList.getId() }&admin=1">관리자 등록</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="ChangeAdminServlet?id=${mList.getId() }&admin=0">관리자 해제</a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>	
				</table>
				<ul>
					<c:forEach begin="1" end="${nOfPage }" var="i">
						<c:choose>
							<c:when test="${currentPage eq i }">
								<li style="font-weight:bold; text-decoration:underline">${i }</li>
							</c:when>
							<c:otherwise>
								<li><a href="AdminServlet?currentPage=${i }">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
		</div>
	</body>
</html>