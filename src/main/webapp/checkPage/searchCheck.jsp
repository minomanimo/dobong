<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항</title>
		<style>
			a{
			 text-decoration:none;
			}
			html{
				width:100%;
			}
			table{
			width:70%;
				text-align:center;
				margin:0 auto;
			}
			body{
				width:99%;
				text-align:center;
				margin:0 auto;
			}
			#write_btn:after{
				content:"";
				display:block;
				clear:both;
			}
			
		</style>
	</head>
	<body>
		<c:if test="${!empty loginUser.id }">
		 <jsp:include page="loginPage.jsp"></jsp:include> 
		</c:if>
		<br>
		<table border="1" style="text-align: center;">
		<thead>
			<tr>
				<th>번호</th>
				<th >제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			</thead>
					<c:forEach items="${search }" var="noticeList">
						<tr>
							<td>${search.getNumber() }</td>
							<td> <a href="NoticeContentServlet?number=${search.getNumber()}"> ${search.getTitle() }</a></td> 
							<td>${search.getNickname() }</td>
							<td>${search.getWritingtime() }</td>
						</tr>
					</c:forEach>
					<tfoot>
					<tr>
						<td colspan="7">
							<form action="NoticeServlet" method="get">
								<input type="hidden" name="currentPage" value="${currentPage }"> <!--이거왜 벨류가 1이지??? -->
								<input type="hidden" id="record" value="${recordsPerPage }">
								<!--  <input type="hidden" name="number" value="0">-->
								<select name="recordsPerPage"> 
									<option value="5"> 5개식 보기</option> 
									<option value="10" selected> 10개식 보기</option>
									<option value="15" > 15개식 보기</option>
								</select>
								<input type="submit" value="보기">
							</form>
							<c:forEach begin="1" end="${nOfPage }" var="i">
								<c:choose>
									<c:when test="${currentPage == i }">	<!--test: 비교연산자 사용하는곳 조건값  -->
										 <a>${i }[현재]</a>
									</c:when> 
								<c:otherwise>
									<li> 
									<a href="NoticeServlet?currentPage=${i }&recordsPerPage=${recordsPerPage}&number=0">${i }</a> </li>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td colspan="7">
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
							<a href="noticeWrite.jsp"> <input type="button" value="글쓰기"> </a>
						</td>		
					</tr>
					
				</tfoot>
			</table>
		<!-- <form action="NoticePageServlet" method="get">
			<input type="hidden" name="currentPage" value="1"> <!--이거왜 벨류가 1이지??? -->
			<!--  <input type="hidden" name="number" value="0">
			<select name="recordsPerPage"> 
				<option value="5"> 5개식 보기</option> 
				<option value="10" selected> 10개식 보기</option>
				<option value="15" > 15개식 보기</option>
			</select>
			<input type="submit" value="보기">
		</form> -->
		<!-- <form action="searchServlet">
			<select name="select"> 
				<option value="1" selected>전체</option>
				<option value="2">내용</option> 
				<option value="3" >제목</option>
				<option value="4" >글쓴이</option>
			</select>
			<input name="searchValue">
			<input type="submit" value="검색">
		</form> -->
		<!-- <ul>
			<c:forEach begin="1" end="${nOfPage }" var="i">
				<c:choose>
					<c:when test="${currentPage == i }">	<!--test: 비교연산자 사용하는곳 조건값  
						<li> <a>${i }[현재]</a> </li>
					</c:when> 
				<c:otherwise>
					<li> 
					<a href="NoticePageServlet?currentPage=${i }&recordsPerPage=${recordsPerPage}&number=0">${i }</a> </li>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul> 
		<br><a href="noticeWrite.jsp"> <input type="button" value="글쓰기"> </a>-->
		<br><a href="index.jsp">홈으로</a>
		<script>
			var record=document.getElementById("record").value;
			var select=document.getElementsByTagName("option");
			if(record==5){
				select[0].selected=true;
			}else if(record==10){
				select[1].selected=true;
			}else{
				select[2].selected=true;
			}
		</script>
	</body>
</html>