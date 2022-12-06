<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Beans.MemberDTO"  %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Dobog DDanBong</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<!-- 타이틀_아이콘 -->
		<link rel="icon" href="images/icon1.ico">
		<!-- 구글 Noto Sans font-->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	</head>
	<body class="is-preload">
		<!-- Header -->
			<header id="header">
				<h1>도 / 봉 / 따 / 봉 </h1>
				<nav>
					<ul>
						<li><a href="#one_park">Park</a></li>
						<li><a href="#two_culture">Culture</a></li>
						<li><a href="#one_cafe">Cafe</a></li>
						<li><a href="#two_restaurant">Restaurant</a></li>
						<li><a href="#one_etc">etc</a></li>
					</ul>
				</nav>
			</header>

		<!-- Intro -->
			<section id="intro" class="main style1 dark fullscreen">
				<div class="content">
					<header>
						<br><br><br>
						<h2>도 / 봉 / 따 / 봉</h2>
					</header>

					<p>서울치고는 뭔가 조금 더디고 머나먼 이곳은 <br>
					시간과 공간의 경계에 서서 없는것 같은데 있고,<br>
					 멈춰 있는 듯 <strong>꾸준히 생기가 도는</strong>
					<strong>숨겨진 무엇이 많은 곳</strong>이기도 하다. <br><br>
					시간이 머문 세월이라는 바탕에 
					새로운 무언가를 칠 할 수 있는 공간이 많은, <br><strong>도봉스러운 장소</strong>를 테마별로 찾아가 보았다.  </p>
					<p class="p_small">
						#무중력지대도봉 #로컬 #생활 #맛집 #문화 
					</p>
					<footer>
						<a href="LandingServlet" class="button style2 down">More</a>
					</footer>
				</div>
			</section>

		<!-- One /Park-->
			<section id="one_park" class="main style2 right dark fullscreen ">
				<div class="content box style2">
					<header>
						<h2>Park</h2>
					</header>
					<p>
						도봉에는 유독 산과 천이 많다. <br>
						구 면적의 상당 부분을 차지하는 도봉산부터<br>
						그 산에서 내려오는 계곡물, <br>
						노원구와의 경계선을 따라 흐르는 중랑천도 있다.   <br><br>
						건물과 생각이 가득한 서울에서, <strong>자연이 곁을 지키는 산책길</strong>의 맑은 공기를 마시며 걷다보면 <br>
						복잡했던 마음이 조금씩 차분해 질 것이다. 
					</p>
				</div>
				<a href="#two" class="button style2 down anchored">Next</a>
			</section>
			

		<!-- Two /Culture -->
			<section id="two_culture" class="main style2 left dark fullscreen">
				<div class="content box style2">
					<header>
						<h2>Culture</h2>
					</header>
					<p>책은 청년에게는 음식이 되고, 노인에게는 오락이 된다.<br>
						부자일 때는 지식이 되고, 고통스러울 때는 위안이 된다.<br>
						<span class="span_center">-키케로-<br><br></span>
						종종 책이 필요할 때가 있다. 과거·현재·미래안에 사람과<br> <strong>삶이 밀도있게 담겨있는 공간</strong>을 찾아가보았다.</p>
				</div>
				<a href="#work" class="button style2 down anchored">Next</a>
			</section>

			<!-- One /Cafe -->
			<section id="one_cafe" class="main style2 right dark fullscreen">
				<div class="content box style2">
					<header>
						<h2>Cafe</h2>
					</header>
					<p>
						커피나 차를 마신다는 ‘행위’ 외에도 <br>
						차 한잔의 ‘시간’ 자체가 가진 매력은 다채롭다. <br><br>
						가끔은 느리게, 때로는 따뜻하거나 시원하게, <br>종종 감정이 부풀려지게 만들기도 한다. <br>
						좋아하는 분야와 감각을 담아<br> 
						나다운 걸음걸이를 걷는 카페가 많아지고 있다. <br><br>
						
						베이커리, 풍경, 식물, 문화까지 맛깔나는 조화를 이룬 <br>
						<strong>도봉에 있는 카페의 다양한 면면</strong>을 살펴보았다.</p>
				</div>
				<a href="#two" class="button style2 down anchored">Next</a>
			</section>
			
			<!-- Two /Restaurant-->
			<section id="two_restaurant" class="main style2 left dark fullscreen">
				<div class="content box style2">
					<header>
						<h2>Restaurant</h2>
					</header>
					<p>
						비건은 어렵거나 까다로운 것이 아니라 그저 나물반찬처럼 일상적인 것이기도 하다.<br>
						그리고 체험해보지 못한 무엇일 수도 있다. <br>
						무거운 주제가 아닌 마음의 방향이 이끄는대로,<br><br>
						<strong>다양한 선택지 중 하나로 존중받기 시작한 변화</strong>를 <br>공간으로 기록했다.
					</p>
				</div>
				<a href="#work" class="button style2 down anchored">Next</a>
			</section>
				<!-- One /etc -->
				<section id="one_etc" class="main style2 right dark fullscreen">
				<div class="content box style2">
					<header>
						<h2>etc</h2>
					</header>
					<p>
						얼굴을 맞대고, 의견을 나누고, 일상을 공유하고,<br>
						아이디어를 떠올리는 <strong>‘만남’</strong><br>
						서로의 교감을 바탕으로 삶이 더 풍성해질 수 있도록, <br>
						만남과 소통을 위한 <strong>오프라인 공간</strong>을 소개한다. 

					</p>
				</div>
				<a href="#two" class="button style2 down anchored">Next</a>
			</section>

		<!-- Work -->
			<section id="work" class="main style3 primary">
				<div class="content">
					<header>
						<h2>Introduce</h2>
						<p>
							This place is a bit slow and far for Seoul.<br>
							Standing at the border of time and space, it seems to be absent, and it is constantly reviving as if it is still.<br>
							It is also a place where there are many hidden things.<br><br>
							On the basis of the years that time stayed<br>
							I visited a dobong-like place with a lot of space where I could paint something new by theme.<br>	
						</p>
					</header>

					<!-- Gallery  -->
						<div class="gallery">
							<article class="from-left">
								<a href="images/img/park/park1.jpg" class="image fit"><img class="img_size" src="images/img/park/park1.jpg" title="Park 우이천" alt="" /></a>
							</article>
							<article class="from-right">
								<a href="images/img/Culture/Culture7.jpg" class="image fit"><img class="img_size" src="images/img/Culture/Culture7.jpg" title="Culture 도도봉봉" alt="" /></a>
							</article>
							<article class="from-left">
								<a href="images/img/cafe/cafe3.jpg" class="image fit"><img class="img_size" src="images/img/cafe/cafe3.jpg" title="Cafe 커피로드" alt="" /></a>
							</article>
							<article class="from-right">
								<a href="images/img/Restaurant/Restaurant2.jpg" class="image fit"><img class="img_size" src="images/img/Restaurant/Restaurant2.jpg" title="Restaurant 하이쿠" alt="" /></a>
							</article>
							<article class="from-left">
								<a href="images/img/etc/etc1.jpg" class="image fit"><img class="img_size" src="images/img/etc/etc1.jpg" title="etc 무중력지대" alt="" /></a>
							</article>
							<article class="from-right">
								<a href="images/img/Culture/Culture4.jpg" class="image fit"><img class="img_size" src="images/img/Culture/Culture4.jpg" title="Culture 김수영문학관" alt="" /></a>
							</article>
						</div>

				</div>
			</section>

		<!-- Contact -->
			<section id="contact" class="main style3 secondary">
				<div class="content">
					<header>
						<h2>당신의 도봉구를 알려주세요</h2>
						<p>	Please tell me which Dobong-gu you recommend</p>
					</header>
					<div class="box">
						<form method="post" action="#">
							<div class="fields">
								<div class="field half"><input type="text" name="name" placeholder="Name" /></div>
								<div class="field half"><input type="email" name="email" placeholder="Email" /></div>
								<div class="field"><textarea name="message" placeholder="Message" rows="6"></textarea></div>
							</div>
							<ul class="actions special">
								<li><input type="submit" value="Send Message" /></li>
							</ul>
						</form>
					</div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">

				<!-- Icons -->
					<ul class="icons">
						<li><a href="https://twitter.com/dobongguoffice" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="https://ko-kr.facebook.com/happyDB/" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
						<li><a href="https://www.instagram.com/dobongguoffice/" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
						<!-- <li><a href="#" class="icon brands fa-linkedin-in"><span class="label">LinkedIn</span></a></li>
						<li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
						<li><a href="#" class="icon brands fa-pinterest"><span class="label">Pinterest</span></a></li> -->
					</ul>

				<!-- Menu -->
					<ul class="menu">
						<li>Copyright ⓒ 무중력지대도봉 도봉따봉 all rights reserved.</li><li>Design:>HTML5 UP</a></li>
					</ul>

			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
	</body>
</html>