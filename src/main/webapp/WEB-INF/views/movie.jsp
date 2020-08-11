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
<link rel='stylesheet' href='/js/bootstrap.bundle.js' type="text/js" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/bootstrap.css'
	type="text/css" />
<title>Movie</title>

<style>
p {
	color: white;
	font-style: italic;
}

div {
	color: white;
}

small {
	color: white;
}
.c1{
 margin-bottom :60px;
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
	<c:set var="funcName" value="Movie" scope="session" />
	<jsp:include page="Navigation.jsp" />
	<jsp:include page="MovieClass.jsp" />
	<div class='c1'>
		<main role="main">
			<div class="container">
				<div class="row" id='movie'></div>
			</div>
		</main>
	</div>
	<script>
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "<c:url value='/allMovies' />", true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var content = "";
				var movies = JSON.parse(xhr.responseText);
				for (var i = 0; i < movies.length; i++) {
					content += "<div class='fade-in col-3 shadow-sm'id='hot' style='border: 0px solid; padding-top: 50px;'>"
							+ "<div>"
							+ "<img width='245px' height='350px' "
							+ " src='"
							+ movies[i].imageData
							+ "'>"
							+ "</div>"

					switch(movies[i].bean.movieRated){
					case '普遍級':
						content += '<p><strong class=" " style="background-color: #13ba45">'+movies[i].bean.movieRated  +'</strong></p>';
						break;
					case '保護級6+':
						content += '<p><strong class="card-text" style="background-color: #4179b0">'+movies[i].bean.movieRated +'</strong></p>';
						break;
					case '輔12級':
						content += '<p><strong class="card-text" style="background-color: #c7c708">'+movies[i].bean.movieRated +'</strong></p>';
						break;
					case '輔15級':
						content += '<p><strong class="card-text" style="background-color: #de8909">'+movies[i].bean.movieRated +'</strong></p>';
						break;
					default:
						content += '<p><strong class="card-text" style="background-color: #FF5151">'+movies[i].bean.movieRated +'</strong></p>';
						break;
				}
					

					content += "<p class='card-text'>"
							+ movies[i].bean.movieName+"<br>"+movies[i].bean.movieEName
							+ "</p>";		
					content += "<div class='d-flex justify-content-between align-items-center'><small class='text-muted'>片長 : "
							+ movies[i].bean.movieLength
							+ "</small></div>";		
							
					content += "<p style='text-align:justify;font-style:normal'>"
							+ movies[i].bean.movieNote
							+ "</p>";
							
							+ "</div>";
					content += "</div>";
				}
				var div = document.getElementById("movie");
				div.innerHTML = content;
			}

		}
		
		
		
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

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../js/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.bundle.js"></script>
</body>

</html>