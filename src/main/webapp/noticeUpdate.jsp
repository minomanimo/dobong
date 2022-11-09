<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="UTF-8">
		<title>게시글 수정페이지</title>
	</head>
	<body>
		<h1>게시글 수정페이지</h1>
		
		<form action="NoticeUpdateServlet" method="post">
			넘버: <input name="number"  type="text"  value="${updateNotice.getNumber() }">
			아이디: <input name="nickname" type="text" value="${loginUser.id}">
			<!-- <input name="nickname" type="hidden" value="${updateNotice.getNickname()}"> -->
			<input name="writingtime" type="hidden" value="${updateNotice.getWritingtime()}">
			
			<table>
				<tr>
					<th>타이틀</th>
					<td>
						<input name="title" value="${updateNotice.getTitle() }">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="10" cols="90" name="content">
							${updateNotice.getContent() }
						</textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="수정하기">
		</form>
		<input type="reset" value="다시작성">
		<a href="NoticeServlet"> <input type="button" value="목록보기"></a>
	</body>
</html>