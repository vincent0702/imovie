<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<style>
* {
	padding: 0;
	margin: 0;
}
.c2 {
	margin:35px;
	padding-top: 10%;
	margin-botton: 20px;
	text-align: left;
}
.fontcss{
	font-family: 'Noto Sans TC', sans-serif;
}

</style>
</head>
<body>
	<div class='c2'>
		<div class='fontcss' style='font-size:20px' id="my">電影類型： <select style="border-radius:5px"  id='publish' onchange="Movies()">
			<option  value='全部'>全部</option>
			<c:forEach var='category' items='${categoryList}'>
				<option value='${category.mGenreName}'>${category.mGenreName}</option>
			</c:forEach>
		</select>
		</div>
	</div>

	<script>
		function Movies() {
			var movieTypeStr = document.getElementById('publish').value;
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "<c:url value='/searchMovieType?typeStr="
					+ movieTypeStr + "'/>", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var movies = JSON.parse(xhr.responseText);
					console.log(movies);
					var content = "";
					for (var i = 0; i < movies.length; i++) {
						console.log(movies[i]);
						//content += "<div class='col-4 shadow-sm'id='hot' style='border: 0px solid; padding-top: 10px;'>"
						content += "<div class='fade-in col-3 shadow-sm'id='hot' style='border: 0px solid; padding-top: 50px;'>"

								+ "<div>"
								+ "<img width='245px' height='350px' "
								+ ' src="' + "<c:url value='/getPicture1/"+movies[i].movieId+"'/>" +'"/>'
								+ "</div>"
								
								switch(movies[i].movieRated){
								case '普遍級':
									content += '<p><strong class=" " style="background-color: #13ba45">'+movies[i].movieRated  +'</strong></p>';
									break;
								case '保護級6+':
									content += '<p><strong class="card-text" style="background-color: #4179b0">'+movies[i].movieRated +'</strong></p>';
									break;
								case '輔12級':
									content += '<p><strong class="card-text" style="background-color: #c7c708">'+movies[i].movieRated +'</strong></p>';
									break;
								case '輔15級':
									content += '<p><strong class="card-text" style="background-color: #de8909">'+movies[i].movieRated +'</strong></p>';
									break;
								default:
									content += '<p><strong class="card-text" style="background-color: #FF5151">'+movies[i].movieRated +'</strong></p>';
									break;
							}						
						content += "<p class='card-text'>"
								+ movies[i].movieName+"<br>"+movies[i].movieEName
								+ "</p>";					
						content += "<div class='d-flex justify-content-between align-items-center'><small class='text-muted'>片長 : "
								+ movies[i].movieLength
								+ "</small></div>";		
						content += "<p class='card-text' style='text-align:justify;font-style:normal'>"
								+ movies[i].movieNote
								+ "</p>";
								+ "</div>"
						content += "</div>";
					}
					var div = document.getElementById("movie");
					div.innerHTML = content;
				}
			}
		}
	</script>
</body>
</html>