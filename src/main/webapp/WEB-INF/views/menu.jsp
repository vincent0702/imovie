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
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/album/">
<link rel='stylesheet' href='js/bootstrap.bundle.js' type="text/js" />
<link rel='stylesheet' href='css/bootstrap.css' type="text/css" />
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&display=swap" rel="stylesheet">
<title>menu</title>
<style>
* {
	padding: 0px;
	margin: 0px;
}

.foodN {
	color: black;
	font-family: 'Noto Sans TC', sans-serif;
	font-weight: 300;
	font-size:20px;
}

div {
	color: white;
}

.setFlex span{
	display: inline-block;
	justify-content: space-around;
	text-align: right;
}
.tran{
	transition-duration: 2s;
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
	<c:set var="funcName" value="menu" scope="session" />
	<jsp:include page="Navigation.jsp" />
	<jsp:include page="FoodClass.jsp" />
	<div class='c1'>
		<main role="main">
			<div class="container">
				<div class="row tran" id='food'></div>
			</div>
		</main>
	</div>
	<script>
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "<c:url value='/allFoods' />", true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var content = "";
				var foods = JSON.parse(xhr.responseText);
				for (var i = 0; i < foods.length; i++) {
					content += "<div class='fade-in col-4 shadow-sm'id='hot' style='border-radius: 10px; margin:20px;padding-top: 20px;background:#E2F2F8'>"
							+ "<div>"
							+ "<img class='imgsize' "
							+ " src='"
							+ foods[i].imageData
							+ "'>"
							+ "</div><div style='display:flex' class='setFlex'>"
							+ "<div  style='margin-top:5px' class='card-text foodN'> "
							+ foods[i].bean.foodName
							+ "</div>"
							+ "<div style='margin-left:10px;text-align: right;float: right;font-weight: 600;font-size: 25px;color:#ED3131'>NT. "
							+ foods[i].bean.foodPrice
							+ "</div>"
							+ "</div>"
					content += "</div>";
				}
				var divs = document.getElementById("food");
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
						.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')
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
</body>

</html>