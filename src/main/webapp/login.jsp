<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
	<title>로그인페이지</title>
		<style type="text/css">
				ul{
				display: inline-block;
			}
			li{
				list-style: none;
				display: inline-block;
			}
			.loginUl li{
				display: inline-block;
			}
			.loginUl li:hover{
				background-color: #ccc;
				cursor: pointer;
			}
			.loginUl:hover~.loginMenu{	/*왜 자식은 안되고 부모만 되는거지??*/
				height: 25px;
				overflow: visible;
				visibility: visible;
			}
			.loginMenu{
				/* display:none; */
				position: absolute;
				top: 15px;
				left:200px;	
				width: 100px;
				text-align: center;
			}
			.loginMenu input{
				height: 30px;
			}
		</style>
	</head>
	<body>
		<div class="loginMenu">
			<form action="LoginServlet" method="post" name=frm>
				<input type="text" name="id" placeholder="ID 입력"><br>
				<input type="password" name="password" placeholder="비밀번호 입력"><br>
				<input type="submit" value="로그인" onclick="return check()">
			</form>
		</div>
		<script type="text/javascript">
			function check() {
				let id=document.frm.id.value;
				console.log(id);
				let password=document.frm.password.value;
				
				if(id.length===0){
					alert("id를 입력해주세요");
					return false;
				}else if(password.length===0){
					alert("비밀번호를 입력해주세요");
					return false;
				}
				return true;
			}
		</script>
		</body>
</html>