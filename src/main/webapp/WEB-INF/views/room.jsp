<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.0.1">
<title></title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/album/">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/js/bootstrap.bundle.js'
	type="text/js" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/bootstrap.css'
	type="text/css" />
<title>Room</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
<style>
p {
	color: white;
}

div {
	color: white;
}

.roomImg {
	height: 250px;
	width: 375px;
}

.fontcss{
	font-family: 'Noto Sans TC', sans-serif;
}
.fade-in{
	-webkit-animation: fade-in-right 0.6s cubic-bezier(0.390, 0.575, 0.565, 1.000) both;
	        animation: fade-in-right 0.6s cubic-bezier(0.390, 0.575, 0.565, 1.000) both;
}

@-webkit-keyframes fade-in-right {
  0% {
    -webkit-transform: translateX(50px);
            transform: translateX(50px);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
    opacity: 1;
  }
}
@keyframes fade-in-right {
  0% {
    -webkit-transform: translateX(50px);
            transform: translateX(50px);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
    opacity: 1;
  }
}
</style>
</head>
<body>
<!-----------------------------回到頂端按鈕------------------------------------->		
<div style="position: fixed; top: 90%; right: -15%; z-index: 999;">
<a class="gototop close" href="#" title="回頂端" alt="回頂端" >
<img id="topimg" style="height:10%;width:10%;opacity:0.3" src="img\cart\totop2.png">
</a></div>
<!-----------------------------回到頂端按鈕------------------------------------->	
	<c:set var="funcName" value="Room" scope="session" />
	<jsp:include page="Navigation.jsp" />
	<jsp:include page="RoomClass.jsp" />

	<div class='c1'>
		<main role="main">
			<div class="container">
				<div class="row" id='room'></div>
			</div>
		</main>
	</div>
	<script>
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "<c:url value='/allRooms ' />", true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var content = "";
				var rooms = JSON.parse(xhr.responseText);
				console.log("rooms:" + rooms);
				for (var i = 0; i < rooms.length; i++) {
					content += "<div class='fade-in fontcss col-4 shadow-sm'id='hot' style='margin-right:100px;margin-bottom:40px;padding-top: 10px;'>"
							+ "<div class='roomImg'>"
							+ "<img style='border-radius:5px' width='100%' height='100%' "
							+ " src='"
							+ rooms[i].imageData
							+ "'>"
							+ "</div>"
							+"<p style='margin-top:15px' class='card-text'>包廂名稱 : "
							+ rooms[i].bean.roomName
							+ "</p>"
							+ "<p class='card-text'>包廂類型 : "
							+ rooms[i].bean.roomSize
							+ "</p>"
							+ "<p class='card-text'>人數 : "
							+ rooms[i].bean.roomPopulation
							+ "</p>"
							+ "<div style='font-size:20px;color:#F15637' class='d-flex justify-content-between align-items-center'><small>預約 : "
							+ rooms[i].bean.roomPrice
							+ "元</small></div>"
							+ "</div>"
					content += "</div>";
				}
				var divs = document.getElementById("room");
				divs.innerHTML = content;
			}
		}
	</script>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery.slim.min.js"><\/script>')
	
	<!-----------------------------回到頂端按鈕- -------------- ---------------------->			
	
		$(window).scroll(function(event){
			  var scroll = $(window).scrollTop();
			    if (scroll >= 200) {
			       $(".gototop").removeClass("close");
			    }else {
			    	$(".gototop").addClass("close");
			    }
			});
		<!-----------------------------回到頂端按鈕------------------------------------->
	</script>
	<script src="js/bootstrap.bundle.js"></script>
</body>

</html>