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
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=z3no9rza2g"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bm5xtq2mgp&submodules=geocoder"></script>
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
				<form action="ReviewServlet" method="get">
					<td colspan="3">${detail.getTextminning1() }
				</form>
				</td>
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

		</c:forEach>
	</table>

	<div id="map" style="width: 100%; height: 400px;"></div>
	<div id="map" style="width: 100%; height: 400px;"></div>
	<script>
			var td=document.getElementsByTagName("td")[3];
			var number=td.getElementsByTagName("input")[2].value;
			$.ajax({
				url:"GetTextmining?number="+number,
				method:"GET",
				async:true,
				success:function(data){
					var text=data.getElementsByTagName("text");
					var count=data.getElementsByTagName("count");
					getText(text,count);
				},
				error:function(log){
					console.log("error");
					console.log(log);
				}
			});
			function getText(text, count){
				for(var i=0; i<text.length; i++){
					console.log(text[i].firstChild.data);
					console.log(count[i].firstChild.data);
				}
			}
			//====================
			//지도 api 서비스 환경등록에 → Web 서비스 URL→  http://localhost을 추가해야 사용가능
			//====================
			/*var mapOptions = {
				    center: new naver.maps.LatLng(37.3595704, 127.105399),
				    zoom: 10
				};

			//var map = new naver.maps.Map('map', mapOptions);
			//마커사용
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(37.3595704, 127.105399),
			    map: map
			});*/
			
			
			//클릭 후 위도,경도 가지고 오기
			var map = new naver.maps.Map("map", {
		    center: new naver.maps.LatLng(37.3595316, 127.1052133),
		    zoom: 15,
		    mapTypeControl: true
		});
		
		var infoWindow = new naver.maps.InfoWindow({
		    anchorSkew: true
		});
		
		map.setCursor('pointer');
		
		function searchCoordinateToAddress(latlng) {
		
		    infoWindow.close();
		
		    naver.maps.Service.reverseGeocode({
		        coords: latlng,
		        orders: [
		            naver.maps.Service.OrderType.ADDR,
		            naver.maps.Service.OrderType.ROAD_ADDR
		        ].join(',')
		    }, function(status, response) {
		        if (status === naver.maps.Service.Status.ERROR) {
		            return alert('Something Wrong!');
		        }
		
		        var items = response.v2.results,
		            address = '',
		            htmlAddresses = [];
		
		        for (var i=0, ii=items.length, item, addrType; i<ii; i++) {
		            item = items[i];
		            address = makeAddress(item) || '';
		            addrType = item.name === 'roadaddr' ? '[도로명 주소]' : '[지번 주소]';
		
		            htmlAddresses.push((i+1) +'. '+ addrType +' '+ address);
		        }
		
		        infoWindow.setContent([
		            '<div style="padding:10px;min-width:200px;line-height:150%;">',
		            '<h4 style="margin-top:5px;">검색 좌표</h4><br />',
		            htmlAddresses.join('<br />'),
		            '</div>'
		        ].join('\n'));
		
		        infoWindow.open(map, latlng);
		    });
		}
		
		function searchAddressToCoordinate(address) {
		    naver.maps.Service.geocode({
		        query: address
		    }, function(status, response) {
		        if (status === naver.maps.Service.Status.ERROR) {
		            return alert('Something Wrong!');
		        }
		
		        if (response.v2.meta.totalCount === 0) {
		            return alert('totalCount' + response.v2.meta.totalCount);
		        }
		
		        var htmlAddresses = [],
		            item = response.v2.addresses[0],
		            point = new naver.maps.Point(item.x, item.y);
		
		        if (item.roadAddress) {
		            htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
		        }
		
		        if (item.jibunAddress) {
		            htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
		        }
		
		        if (item.englishAddress) {
		            htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
		        }
		
		        infoWindow.setContent([
		            '<div style="padding:10px;min-width:200px;line-height:150%;">',
		            '<h4 style="margin-top:5px;">검색 주소 : '+ address +'</h4><br />',
		            htmlAddresses.join('<br />'),
		            '</div>'
		        ].join('\n'));
		
		        map.setCenter(point);
		        infoWindow.open(map, point);
		    });
		}
		
		function initGeocoder() {
		    map.addListener('click', function(e) {
		        searchCoordinateToAddress(e.coord);
		    });
		
		    $('#address').on('keydown', function(e) {
		        var keyCode = e.which;
		
		        if (keyCode === 13) { // Enter Key
		            searchAddressToCoordinate($('#address').val());
		        }
		    });
		
		    $('#submit').on('click', function(e) {
		        e.preventDefault();
		
		        searchAddressToCoordinate($('#address').val());
		    });
		
		    searchAddressToCoordinate('정자동 178-1');
		}
		
		function makeAddress(item) {
		    if (!item) {
		        return;
		    }
		
		    var name = item.name,
		        region = item.region,
		        land = item.land,
		        isRoadAddress = name === 'roadaddr';
		
		    var sido = '', sigugun = '', dongmyun = '', ri = '', rest = '';
		
		    if (hasArea(region.area1)) {
		        sido = region.area1.name;
		    }
		
		    if (hasArea(region.area2)) {
		        sigugun = region.area2.name;
		    }
		
		    if (hasArea(region.area3)) {
		        dongmyun = region.area3.name;
		    }
		
		    if (hasArea(region.area4)) {
		        ri = region.area4.name;
		    }
		
		    if (land) {
		        if (hasData(land.number1)) {
		            if (hasData(land.type) && land.type === '2') {
		                rest += '산';
		            }
		
		            rest += land.number1;
		
		            if (hasData(land.number2)) {
		                rest += ('-' + land.number2);
		            }
		        }
		
		        if (isRoadAddress === true) {
		            if (checkLastString(dongmyun, '면')) {
		                ri = land.name;
		            } else {
		                dongmyun = land.name;
		                ri = '';
		            }
		
		            if (hasAddition(land.addition0)) {
		                rest += ' ' + land.addition0.value;
		            }
		        }
		    }
		
		    return [sido, sigugun, dongmyun, ri, rest].join(' ');
		}
		
		function hasArea(area) {
		    return !!(area && area.name && area.name !== '');
		}
		
		function hasData(data) {
		    return !!(data && data !== '');
		}
		
		function checkLastString (word, lastString) {
		    return new RegExp(lastString + '$').test(word);
		}
		
		function hasAddition (addition) {
		    return !!(addition && addition.value);
		}
		
		naver.maps.onJSContentLoaded = initGeocoder;
		</script>
</body>
</html>