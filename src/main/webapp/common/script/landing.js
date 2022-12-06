$( document ).ready( function() {
	//추가설정: class=slideImg div  설정, head 내 슬릭, 제이쿼리 script 주소설정
	  $(".slide").slick({
			slide:"div",
	        slidesToShow: 1,
	        slidesToScroll: 1,
	        centerMode: true,
	        centerpadding: '0px',
	        variableWidth: true,
	        autoplay: true,
	        infinite : true, 
	        autoplaySpeed: 2000,
	        pauseOnHover : true,
	        arrows: true,
	        dots : true,
	        speed:1000,
	        //버튼 설정
            prevArrow: "<i class='prevArrow fa-regular fa-circle-left'></i>", 
            nextArrow: "<i class='nextArrow fa-regular fa-circle-right'></i>"
	    });
});