<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
		<title>상세페이지</title>
		
		<!-- 아이콘 -->
		<link rel="icon" href="images/icon1.ico">
		
		<script type="text/javascript"
			src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=z3no9rza2g"></script>
		<script type="text/javascript"
			src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bm5xtq2mgp&submodules=geocoder"></script>
		<script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
    	<script src="https://cdn.anychart.com/releases/v8/js/anychart-tag-cloud.min.js"></script>
		<style type="text/css">

		td {
			border: 1px solid #ccc;
		}
		
		img {
			width: 150px;
			height: 150px;
		}
		</style>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body>
	
		<h1>${request.getImageurl() }</h1>
		<table>
			<c:forEach items="${detail }" var="detail">
				<tr>
					<td><img alt="1" src="${detail.getImageurl() }"></td>
					<!--  <td> <img alt="1" src="${detail.getImageurl() }"> </td>
							<td> <img alt="1" src="${detail.getImageurl() }"> </td> -->
				</tr>
				<tr>
					<td colspan="3">${detail.getDetailpage() }${detail.getNumber() }
						${detail.getShortpage() }</td>
				</tr>
				<tr>
					<form action="ReviewServlet" method="get"><!-- 텍스트 마이닝 시작 -->
						<td colspan="3">${detail.getTextminning1() }</td>
					</form>
				</tr>
				<tr>
					<form action="ReviewServlet" method="post">
						<td colspan="3"><input name="review"> <input
							type="submit" value="리뷰작성"> <!-- 디테일페이지가 다시  --> <input
							type="hidden" value="${detail.getNumber() }" name="number">
							<input type="hidden" value="${detail.shortpage }" name="shortpage">
						</td>
					</form>
				</tr>
	
				<tr>
					<td colspan="3">많이 집계된 리뷰를 보는곳입니다<br>
					</td>
				</tr>
				<tr>
					<td colspan="7"></td>
				</tr>
				<input type="hidden" value="${detail.getApi_latitude() }" id="lat">
				<input type="hidden" value="${detail.getApi_longitude() }" id="lng">
				<input type="hidden" value="${detail.getDetailpage() }" id="name">
			</c:forEach>
		</table>
		<div id="container"></div>
		<div id="map" style="width: 100%; height: 400px;"></div>
		<div id="map" style="width: 100%; height: 400px;"></div>
		<script>
			var td=document.getElementsByTagName("td")[3];	//테이블의 세 번째 td에서 값을 가져옴 45번줄
			var number=td.getElementsByTagName("input")[2].value;	//2번째 인풋에 값을 전달 52번째 줄
			$.ajax({
				url:"GetTextmining?number="+number,		//GetTextmining 서블릿으로 전송 Get 방식
				method:"GET",
				async:true,
				success:function(data){							//텍스트마이닝 가져올때 5회이상 카운트 된 값만 전달.
					var text=data.getElementsByTagName("text");//이 값을 서블릿으로 넘겨줌
					var count=data.getElementsByTagName("count");//위와 마찬가지
					getText(text,count);
					console.log(text);
					console.log(count);
				},
				error:function(log){
					console.log("error");
					console.log(log);
				}
			});
			function getText(text, count){
				var data=new Array();
				for(var i=0; i<text.length; i++){
					console.log(text[i].firstChild.data);	//텍스트 배열
					console.log(count[i].firstChild.data);	//카운트 배열
					var arr=new Object();
					arr.x=text[i].firstChild.data;
					arr.value=count[i].firstChild.data;
					data.push(arr);
				}
				
				console.log(data);
				anychart.onDocumentReady(function () {
			        var chart = anychart.tagCloud(data);
			        chart.angles([0]);
			        chart.container("container");
			        // chart.getCredits().setEnabled(false);
			        chart.draw();
			      }); 
			}//여기까지가 텍스트 마이닝 부분임.
			
			//====================
			//지도 api 서비스 환경등록에 → Web 서비스 URL→  http://localhost을 추가해야 사용가능
			//====================
			var lat=document.getElementById("lat").value;
			var lng=document.getElementById("lng").value;
			
			var mapOptions = {
				    center: new naver.maps.LatLng(lat, lng),
				    zoom: 17
				};
			var map = new naver.maps.Map('map', mapOptions);
			//마커사용
			
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(lat, lng),
			    map: map
			});
			
			$.ajax({
				url:"NaverMapRv?coord="+lng+","+lat,
				method:"GET",
				async:true,
				success:function(data){
					var str=data.getElementsByTagName("data")[0].firstChild.data;
					var arr=JSON.parse(str);
					markerClick(arr.results[0],arr.results[1]);
				},
				error:function(log){
					console.log("error");
					console.log(log);
				}
			});
			var infoWindow=new naver.maps.InfoWindow();
			function markerClick(addr, roadaddr){
				
				var jibun=[
					addr.region.area1.name,
					addr.region.area2.name,
					addr.region.area3.name,
					addr.region.area4.name,
					addr.land.number1+(addr.land.number2==''? '' : "-"+addr.land.number2)
				].join(" ");
				var road=[
					roadaddr.region.area1.name,
					roadaddr.region.area2.name,
					roadaddr.land.name,
					roadaddr.land.number1+(roadaddr.land.number2==''?'':' '+roadaddr.land.number2),
					roadaddr.land.addition0.value
				].join(" ");
				naver.maps.Event.addListener(marker,'click',function(){
					var name=document.getElementById("name").value;
					
					infoWindow.setContent([
						'<div style="padding:10px;min-width:200px;">',
			            '<h4 style="margin-top:5px;">'+ name +'</h4>',
			            jibun, '<br />',
			            road, '</div>'
					].join("\n"));
					infoWindow.open(map, marker);
				});
			}
			
			naver.maps.Event.addListener(map, 'click', function () {
		        infoWindow.close();
		    });
			</script>
	</body>
</html>