<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
<style>
.c2 {
	margin:35px;
	padding-top: 10%;
	margin-botton: 20px;
	text-align: left;
}

.roomImg {
	height: 250px;
	width: 375px;
	
}

.fontcss{
	font-family: 'Noto Sans TC', sans-serif;
}
</style>
</head>
<body>
	
	<div class='c2'>
	<div class='fontcss' style='font-size:20px' >包廂類型 : <select style="border-radius:5px" id='publish' onchange="Rooms()">
		<option value='全部'>全部</option>
		<c:forEach var='category' items='${categoryList}'>
			<option value='${category}'>${category}</option>
		</c:forEach>
	</select>
	</div>
	</div>
	
	<script>
		function Rooms() {
			var roomTypeStr = document.getElementById('publish').value;
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "<c:url value='/allRoom?roomTypeStr=" + roomTypeStr
					+ "'/>", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var rooms = JSON.parse(xhr.responseText);
					var content = "";
					for (var i = 0; i < rooms.length; i++) {
						content += "<div class='fade-in fontcss col-4 shadow-sm'id='hot' style='margin-right:100px;margin-bottom:40px;padding-top: 10px;'>"
								+ "<div class='roomImg'>"
								+ "<img style='border-radius:5px' width='100%' height='100%' "
								+ ' src="' + "<c:url value='/getPicture2/"+rooms[i].roomId+"'/>" +'"/>'
								+ "</div>"
								+"<p style='margin-top:15px' class='card-text'>包廂名稱 : "
								+ rooms[i].roomName
								+ "</p>"
								+ "<p class='card-text'>包廂類型 : "
								+ rooms[i].roomSize
								+ "</p>"
								+ "<p class='card-text'>人數 : "
								+ rooms[i].roomPopulation
								+ "</p>"
								+ "<div style='font-size:20px;color:#F15637' class='d-flex justify-content-between align-items-center'><small>預約 : "
								+ rooms[i].roomPrice
								+ "元</small></div>"
								+ "</div>"
						content += "</div>";
					}
					var div = document.getElementById("room");
					div.innerHTML = content;
				}
			}
		}
	</script>




</body>
</html>