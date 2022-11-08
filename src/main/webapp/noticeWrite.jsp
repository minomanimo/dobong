<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		<h1>공지사항 글쓰기 </h1>
		<table>
			<form action="NoticeWriteServlet" method="post">
				<tr> 
					<td><input type="text" name="id" placeholder="id를 적어주세요"></td> 
				</tr>
				<tr> 
					<td> <input type="text" name="password" placeholder="비밀번호를 적어주세요"></td> 
				</tr>
				<tr> 
					<td> <input type="text" name="title" placeholder="제목"></td> 
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
	</body>
</html>