<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
.imgsize{
	width:240px;
	height:168px
}
.fontcss{
	font-family: 'Noto Sans TC', sans-serif;
}
</style>
</head>
<body>
	<div class='c2'>
		<div class='fontcss' style='border-radius:20px;font-size:20px'>餐點類型 : <select style="border-radius:5px" id='publish' onchange="Foods()">
			<option value='全部'>全部</option>
			<c:forEach var='category' items='${categoryList}'>
				<option value='${category.fGenreName}'>${category.fGenreName}</option>
			</c:forEach>
		</select>
		</div>
	</div>

	<script>
		function Foods() {
			var foodTypeStr = document.getElementById('publish').value;
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "<c:url value='/allFood?foodTypeStr=" + foodTypeStr
					+ "'/>", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var foods = JSON.parse(xhr.responseText);
					var content = "";
					for (var i = 0; i < foods.length; i++) {
							content += "<div class='fade-in col-4 shadow-sm'id='hot' style='border-radius: 10px; margin:20px;padding-top: 20px;background:#E2F2F8'>"
								+ "<div>"
								+ "<img class='imgsize' "
								+ ' src="' + "<c:url value='/getPicture/"+foods[i].foodId+"'/>" +'"/>'  
								+ "</div>"
								+ "<div style='display:flex' class='setFlex'>"
								+ "<div  style='margin-top:5px' class='card-text foodN'> "
								+ foods[i].foodName
								+ "</div>"
								+ "<div style='margin-left:10px;text-align: right;float: right;font-weight: 600;font-size: 25px;color:#ED3131'>NT. "
								+ foods[i].foodPrice
								+ "</div>"
								+ "</div>"
							content += "</div>";
					}
					
					var div = document.getElementById("food");
					div.innerHTML = content;
				}
			}
		}
	</script>




</body>
</html>