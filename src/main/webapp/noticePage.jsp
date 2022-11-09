<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
		<title>공지사항</title>
		<style type="text/css">
			td{
				border: 1px solid #ccc;
			}
			ul{
				display: inline-block;
			}
			li{
				list-style: none;
				display: inline-block;
			}
		</style>
		</head>
	<body>
		<!--여기서는 페이지별로 보여주기-->
		<jsp:include page="loginPage.jsp"></jsp:include>
		<table border="1" style="text-align: center;">
			<thead>
				<tr>
					<th>번호</th>
					<th >제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<c:forEach items="${data }" var="data">
				<tr>
					<td>${data.getNumber() }</td>
					<td> <a href="NoticeContentServlet?number=${data.getNumber()}"> ${data.getTitle() }</a></td> 
					<!-- <td>${noticeList.getContent() }</td> -->
					<td>${data.getNickname() }</td>
					<td>${data.getWritingtime() }</td>
				</tr>
			</c:forEach>
		</table>
		<form action="NoticePageServlet" method="get">
			<input type="hidden" name="currentPage" value="1">
			<select name="recordsPerPage"> 
				<option value="5"> 5개 보기</option> 
				<option value="10" selected> 10개 보기</option>
				<option value="15" > 15개 보기</option>
			</select>
			<input type="submit" value="보기">
		</form>
		<ul>
			<c:forEach begin="1" end="${nOfPage }" var="i">
				<c:choose>
					<c:when test="${currentPage == i }">	<!--test: 비교연산자 사용하는곳 조건값  -->
						<li> <a>${i }(현재)</a> </li>
					</c:when> 
				<c:otherwise>
					<li> <a href="NoticePageServlet?currentPage=${i }&recordsPerPage=${recordsPerPage}&number=0">${i }</a> </li>
				</c:otherwise>
				</c:choose>
			</c:forEach>
			<br><br>
			<form action="searchServlet">
			<select name="select"> 
				<option value="1" selected>전체</option>
				<option value="2">내용</option> 
				<option value="3" >제목</option>
				<option value="4" >글쓴이</option>
			</select>
			<input name="searchValue">
			<input type="submit" value="검색">
			</form>
		</ul>
		
	</body>
</html>