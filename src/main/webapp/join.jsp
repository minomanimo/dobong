<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="utf-8">
		<title>회원가입</title>
		<!-- 아이콘 -->
		<link rel="icon" href="images/icon1.ico">
		<style type="text/css">
			table, td{
				border: 1px solid #ccc;
			}
			input, td{
				height: 30px;
			}
		</style>
	</head>
	<body>
		<h1> 회원가입</h1>
		<form action="JoinServlet" method="post" name="join">
		<table>
				<tr>
					<td> <input type="text" name="name" placeholder="이름을 적어주세요"> </td>
				</tr>
				<tr>
				<td> <input type="text" name="nickname" placeholder="닉네임을 적어주세요"> </td>
				</tr>
				<tr>
					<td> <input type="password" name="password" placeholder="비밀번호를 적어주세요"> </td>
				</tr>
				<tr>
					<td> <input type="text" name="phone" placeholder="번호를 적어주세요"> </td>
				</tr>
				<tr>
					<td> <input type="text" name="email" placeholder="이메일을 적어주세요"> </td>
				</tr>
				<tr>
					<td> <input type="text" name="address" placeholder="주소를 적어주세요"> </td>
				</tr>
				<!--약관의 경우 같은 name명 사용 벨류값이 여러개라서 해당값을 보기위해서는 for사용-->
				<tr>
					<td> <input type="checkbox" name="tos" value="1">약관 1</td>
				</tr>
				<tr>
					<td> <input type="checkbox" name="tos" value="2" >약관 2</td>
				</tr>
				<tr>
					<td> <input type="text" name="meter" placeholder="가입이유를 적어주세요"> </td>
				</tr>
				<tr>
					<td> <input type="submit" value="가입"> </td>
				</tr>
			</table>
		</form>
	</body>
</html>