<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원정보 수정</title>
		<style>
		      a {
		        text-decoration: none;
		      }
    	</style>
	</head>
	<body>
		 <div id="wrap">
		 <h1>마이페이지</h1>
		 <!-- members -->
		 	<form action="RegisterUpdateServlet" method="post">
		 		<input name="id" type="hidden" value="${members.getId() }" type="" ><br>
		 		<input name="number" type="hidden" value="${members.getNumber() }">
	 			<input name="email" type="hidden" value="${members.getEmail() }">
		 		<input name="tos1" type="hidden" value="${members.getTos1() }">
		 		<input name="tos2" type="hidden" value="${members.getTos2() }">
		 		<input name="meter" type="hidden" value="${members.getMeter() }">
		 		<input name="admin" type="hidden" value="${members.getAdmin() }">

		 		<input name="nickname" value="${members.getNickname() }" placeholder="닉네임을 적어주세요"> 
	 			<input type="button" value="중복확인">	<br> 		
		 		<input name="password" type="password" placeholder="비밀번호는 8~20자의 영문 대소문자, 숫자, 특수문자"><br>
		 		<input name="name" value="${members.getName() }" placeholder="이름"><br>
		 		<input name="phone" value="${members.getPhone() }"  placeholder="전화번호"><br>
		 		<input name="address" value="${members.getAddress() }"  placeholder="주소"><br><br>
		 		
		 		<input type="submit" value="수정하기">
		 		<input type="reset" value="다시작성">
		 	</form>
		 </div>
	</body>
</html>