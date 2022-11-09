<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>상세페이지</title>
		<style type="text/css">
			td{
				border: 1px solid #ccc;
			}
			img{
				width: 150px;
				height: 150px;
			}
		</style>
	</head>
	<body>
	
	<h1>${request.getImageurl() }</h1>
		 <table>
		<!--	<tr>
				<td>업체 사진</td>
				<td> <img alt="1" src="img/img1.jpg"> </td>
			</tr>
			<tr>
				<td>대분류명</td>
				<td>${detail[0].shortpage}</td>
				<!-- 어레이리스트 타입이니까 데이터를 사용하고 싶을떄는! 당연히 인덱스를 적어야함 
			</tr>
			<tr>
				<td>업체명</td>
				<td>${detail[0].detailpage}</td>
			</tr>
			<tr>
				<td>리뷰</td>
				<td>맛있네요</td>
			</tr>
			<tr>
				<td>별점</td>
				<td>
					<input type="radio" name="stars">맛있다!<br>
					<input type="radio" name="stars">깨끗하다!
				</td>
			</tr>
			
			 -->
				<c:forEach items="${detail }" var="detail">
					<tr>
						<td> <img alt="1" src="${detail.getImageurl() }"> </td>
						<!--  <td> <img alt="1" src="${detail.getImageurl() }"> </td>
						<td> <img alt="1" src="${detail.getImageurl() }"> </td> -->
					</tr>
					<tr>
						<td colspan="3">${detail.getDetailpage() }
							${detail.getNumber() }
							${detail.getShortpage() }
						</td>
					 </tr>
						 <tr>
						 	<form action="ReviewServlet" method="get">
								<td colspan="3">
									<!-- <label> <input type="radio" name="stars" value="1"> ${detail.getTextminning1() }</label><br>
									<label> <input type="radio" name="stars" value="2"> ${detail.getTextminning2() }</label><<br>
									<label> <input type="radio" name="stars" value="3"> ${detail.getTextminning2() }</label>
									<input type="submit" value="투표하기"> -->
									${detail.getTextminning1() }
							</form>
								</td>
						</tr>
						 <tr>
							 <form action="ReviewServlet" method="post">
							 	<td colspan="3">
							 			<input name="review">
							 			<input type="submit" value="리뷰작성">
							 			<!-- 디테일페이지가 다시  -->
							 			<input type="hidden" value="${detail.getNumber() }" name="number">
							 			<input type="hidden" value="${detail.shortpage }" name="shortpage">
							 	</td>
							</form>		 	
						 </tr>
					 
					 <tr>
					 	<td colspan="3">
					 		많이 집계된 리뷰를 보는곳입니다<br>
					 	</td>
					 </tr>
					  <tr>
					 	<td colspan="3">
					 		네이버 지도
					 	</td>
					 </tr>
				
				</c:forEach>
		</table>
		
		
	</body>
</html>