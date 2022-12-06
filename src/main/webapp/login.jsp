<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
	<title>로그인페이지</title>
	<!-- 아이콘 -->
		<link rel="icon" href="images/icon1.ico">
		<link rel="stylesheet" href="./common/css/login.css">
	</head>
	<body>
		<div id="wrap">
			<div class="loginwrap">
				<form action="LoginServlet" method="post" id="frm" name=frm>
					<div class="loginMenu">
						<div class="loing_h1">
							<h1>LOGIN</h1>
						</div>
						<div class="login_id">
							<h4>ID</h4>
							<input type="text" name="id" placeholder="ID를 입력해주세요">
						</div>
						<div class="login_pw">
							<h4>PASSWORD</h4>	
							<input type="password" name="password" placeholder="비밀번호 입력해주세요">
						</div>
						<div class="login_etc">
							<div class="forgot_pw"><a href="forgot_pw.jsp">비밀번호를 잊으셨나요?</a>
							</div>
						</div>
						<div class="login_submit">
							<input type="submit" value="로그인" onclick="return check()">
						</div>
					</div>
				</form>
			</div>	
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