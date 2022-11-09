<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="utf-8">
		<title>공지사항</title>
		<style> 
	
			ol{
			float:left;
			border:1px solid black;
			
			}
		</style>
	</head>
	<body>
		<c:choose>
			<c:when test="${!empty loginUser.id }">
				<h1>공지사항 글쓰기 </h1>
				<table>
					<form action="NoticeWriteServlet" method="post">
						<c:if test="${!empty loginUser.id }">
							<tr> 
								<td><input value="${loginUser.id }" name="id"></td> 
							</tr>
						</c:if>
						<!-- <tr> 
							<td> <input type="text" name="password" placeholder="비밀번호를 적어주세요"></td> 
						</tr> -->
						<tr> 
							<td> <input name="title" placeholder="제목"></td> 
						</tr>
						<tr> 
							<td> <textarea name="content"></textarea></td> 
						</tr>
						<tr>
							<td>
								<input type="submit" value="작성완료">
								<input type="reset" value="다시작성">
							</td>
						</tr>
					</form>
				</table>
			</c:when>
			<c:otherwise>
				<script>
					alert("글쓰기는 로그인 사용자만 가능합니다.");
					location.href="login.jsp";
				</script>				
			</c:otherwise>
		</c:choose>
	</body>
</html>